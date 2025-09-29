package br.com.bb9leko.rest;

import br.com.bb9leko.rest.client.InterfaceTransacao;
import br.com.bb9leko.vo.Transacao;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.Collections;
import java.util.List;

@Path("/transacao")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BuscarTransacaoPorID {

    @Inject
    @RestClient
    InterfaceTransacao interfaceTransacao;

    @GET
    @Path("buscarTransacaoPorId/{id}")
    public Transacao buscarTransacaoPorId(@PathParam("id") Long id) {
        try {
            // Chama a API externa via REST client
            return interfaceTransacao.buscarTransacaoPorId(id);
        } catch (Exception e) {
            e.printStackTrace();
            // Retorne null ou lance uma exceção conforme sua necessidade
            return null;
        }
    }
}
