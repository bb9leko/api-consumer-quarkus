package br.com.bb9leko.rest;

import br.com.bb9leko.service.SolicitarTransacoesPorTicketService;
import io.quarkus.logging.Log;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/solicitar")
@Produces(MediaType.APPLICATION_JSON)
public class SolicitarTransacoesPorTicketResource {

    @Inject
    SolicitarTransacoesPorTicketService service;

    @GET
    public Response solicitarPorTicket(@QueryParam("q") String ticket) {
        Log.info("Solicitação recebida para ticket: " + ticket);

        Long controleId = service.iniciarSolicitacao(ticket);

        return Response.accepted()
                .entity(new SolicitacaoResponse(controleId, ticket, "Requisição em andamento"))
                .build();
    }

    public static class SolicitacaoResponse {
        public Long controleId;
        public String ticket;
        public String status;

        public SolicitacaoResponse(Long controleId, String ticket, String status) {
            this.controleId = controleId;
            this.ticket = ticket;
            this.status = status;
        }
    }
}
