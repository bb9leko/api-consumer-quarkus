package br.com.bb9leko.rest;

import br.com.bb9leko.rest.client.InterfaceTransacao;
import br.com.bb9leko.service.BuscarPorTicketService;
import br.com.bb9leko.vo.Transacao;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.Collections;
import java.util.List;

@Path("/transacao/buscarPorTicket")
@Produces(MediaType.APPLICATION_JSON)
public class BuscarPorTicket {

    @Inject
    BuscarPorTicketService buscarPorTicketService;

    @GET
    public List<Transacao> buscarPorTicket(@QueryParam("q") String ticket) {
        return buscarPorTicketService.buscarPorTicket(ticket);
    }
}