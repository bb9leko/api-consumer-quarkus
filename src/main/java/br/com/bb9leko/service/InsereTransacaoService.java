package br.com.bb9leko.service;

import br.com.bb9leko.rest.client.InterfaceTransacao;
import br.com.bb9leko.vo.Transacao;
import io.vertx.mutiny.core.eventbus.EventBus;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.logging.Level;
import java.util.logging.Logger;

@ApplicationScoped
public class InsereTransacaoService{

    private static final Logger LOGGER = Logger.getLogger(InsereTransacaoService.class.getName());

    @Inject
    @RestClient
    InterfaceTransacao interfaceTransacao;

    //@Inject
    //EventBus bus;

    //private final Jsonb jsonb = JsonbBuilder.create();

    public Response insereTransacaoService(Transacao dto) {
        try {
            //String payload = jsonb.toJson(dto);
            //bus.send("transacao.insere", payload);
            //LOGGER.info("Transacao enfileirada em transacao.insere");
            //return Response.accepted().entity("Transacao enfileirada").build();
            Response response = interfaceTransacao.insereTransacao(dto);
            return response;
        } catch (Exception e) {
            //e.printStackTrace();
            //LOGGER.log(Level.SEVERE, "Falha ao enfileirar transacao", e);
            //return Response.serverError().entity("Falha ao enfileirar transacao").build();
            e.printStackTrace();
            return Response.serverError().build();
        }
    }
}
