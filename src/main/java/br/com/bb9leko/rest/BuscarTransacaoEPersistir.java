package br.com.bb9leko.rest;

import br.com.bb9leko.entity.TransacaoEntity;
import br.com.bb9leko.rest.client.InterfaceTransacao;
import br.com.bb9leko.service.BuscarTransacaoEPersistirService;
import br.com.bb9leko.vo.Transacao;
import io.quarkus.logging.Log;
import io.vertx.core.eventbus.EventBus;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;
import java.util.logging.Logger;

@Path("/transacao/buscarTransacaoEPersistir")
@Produces(MediaType.APPLICATION_JSON)
public class BuscarTransacaoEPersistir {

    @Inject
    @RestClient
    InterfaceTransacao interfaceTransacao;

    @Inject
    BuscarTransacaoEPersistirService buscarTransacaoEPesisitirService;

    @Inject
    EventBus bus;

    /*@GET
    public List<TransacaoEntity> buscarPorTicket(@QueryParam("q") String ticket) {
        return buscarTransacaoEPesisitirService.buscarTransacaoEPersistir(ticket);
    }*/

    @GET
    public Response buscarPorTicket(@QueryParam("q") String ticket){
        try {
            Log.info("Iniciando busca para: " + ticket);
            bus.send("buscarTransacaoEPersistir", ticket);
            Log.info("Requisição Enviada:");
        } catch (Exception e) {
            Log.error("Erro ao buscar transações: " + e.getMessage(), e);
        }
        return Response.ok().build();
    }
}
