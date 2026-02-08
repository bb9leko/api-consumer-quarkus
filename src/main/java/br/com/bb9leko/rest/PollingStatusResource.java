package br.com.bb9leko.rest;

import br.com.bb9leko.entity.ControleTransacao;
import br.com.bb9leko.enums.EstadoTransacao;
import br.com.bb9leko.repository.ControleTransacaoRepository;
import io.quarkus.logging.Log;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Path("/status")
@Produces(MediaType.APPLICATION_JSON)
public class PollingStatusResource {

    private static final long TIMEOUT_MINUTOS = 1;

    @Inject
    ControleTransacaoRepository controleRepository;

    @GET
    @Path("/{ticket}")
    public Response consultarStatus(@PathParam("ticket") String ticket) {
        Log.info("Polling status para: " + ticket);

        // Busca o estado mais recente
        Optional<ControleTransacao> ultimoEstadoOpt = controleRepository.findUltimoEstadoByTicket(ticket);

        if (ultimoEstadoOpt.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(new StatusResponse("NAO_ENCONTRADO", "Ticket não encontrado", null))
                    .build();
        }

        ControleTransacao ultimoEstado = ultimoEstadoOpt.get();

        // Busca primeiro registro para calcular timeout
        Optional<ControleTransacao> primeiroEstadoOpt = controleRepository.findPrimeiroEstadoByTicket(ticket);
        LocalDateTime iniciadoEm = primeiroEstadoOpt.map(ControleTransacao::getDataCriacao).orElse(null);

        // Verifica timeout de 1 minuto
        if (isTimeout(iniciadoEm, ultimoEstado)) {
            return Response.status(Response.Status.REQUEST_TIMEOUT)
                    .entity(new StatusResponse("TIMEOUT", "Requisição expirou após 1 minuto", iniciadoEm))
                    .build();
        }

        // Verifica estado
        if (ultimoEstado.getDescricaoEstado().equals(EstadoTransacao.FINALIZADA.getDescricao())) {
            return Response.ok(new StatusResponse("FINALIZADA", "Processamento concluído", iniciadoEm))
                    .build();
        }

        if (ultimoEstado.getDescricaoEstado().equals(EstadoTransacao.ERRO.getDescricao())) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new StatusResponse("ERRO", ultimoEstado.getMensagemErro(), iniciadoEm))
                    .build();
        }

        // Ainda em andamento
        return Response.status(202)
                .entity(new StatusResponse("EM_ANDAMENTO", "Processando...", iniciadoEm))
                .build();
    }

    @GET
    @Path("/{ticket}/historico")
    public Response consultarHistorico(@PathParam("ticket") String ticket) {
        Log.info("Consultando histórico para: " + ticket);

        List<ControleTransacao> historico = controleRepository.findHistoricoByTicket(ticket);

        if (historico.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Ticket não encontrado")
                    .build();
        }

        return Response.ok(historico).build();
    }

    private boolean isTimeout(LocalDateTime iniciadoEm, ControleTransacao ultimoEstado) {
        if (iniciadoEm == null) return false;

        Duration duracao = Duration.between(iniciadoEm, LocalDateTime.now());
        return duracao.toMinutes() >= TIMEOUT_MINUTOS &&
                ultimoEstado.getDescricaoEstado().equals(EstadoTransacao.EM_ANDAMENTO.getDescricao());
    }

    public static class StatusResponse {
        public String status;
        public String mensagem;
        public LocalDateTime iniciadoEm;

        public StatusResponse(String status, String mensagem, LocalDateTime iniciadoEm) {
            this.status = status;
            this.mensagem = mensagem;
            this.iniciadoEm = iniciadoEm;
        }
    }
}
