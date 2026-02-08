package br.com.bb9leko.service;

import br.com.bb9leko.rest.client.InterfaceTransacao;
import br.com.bb9leko.vo.Transacao;
import br.com.bb9leko.vo.TransacaoComTicket;
import io.quarkus.logging.Log;
import io.quarkus.vertx.ConsumeEvent;
import io.smallrye.common.annotation.Blocking;
import io.vertx.mutiny.core.eventbus.EventBus;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;

@ApplicationScoped
public class BuscarTransacaoPorTicketService {

    @Inject
    @RestClient
    InterfaceTransacao interfaceTransacao;

    @Inject
    EventBus bus;

    @Blocking
    @ConsumeEvent("buscarTransacaoPorTicket")
    public void buscar(String ticket) {
        Log.info("Buscando transações externas para: " + ticket);

        try {
            List<Transacao> transacoes = interfaceTransacao.buscarPorTicket(ticket);

            // Envia para persistência com o ticket
            TransacaoComTicket payload = new TransacaoComTicket(ticket, transacoes);
            bus.send("persistirTransacoesAsync", payload);

        } catch (Exception e) {
            Log.error("Erro ao buscar transações: " + e.getMessage(), e);

            // Envia erro para atualizar controle
            bus.send("erroTransacao", new ErroTransacao(ticket, e.getMessage()));
        }
    }

    public static class ErroTransacao {
        public String ticket;
        public String mensagem;

        public ErroTransacao(String ticket, String mensagem) {
            this.ticket = ticket;
            this.mensagem = mensagem;
        }
    }
}
