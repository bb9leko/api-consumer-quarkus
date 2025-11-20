package br.com.bb9leko.rest;

import br.com.bb9leko.rest.client.InterfaceTransacao;
import br.com.bb9leko.service.BuscarTransacaoPorIDService;
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
    BuscarTransacaoPorIDService buscarTransacaoPorIDService;

    @GET
    @Path("buscarTransacaoPorId/{id}")
    public Transacao buscarTransacaoPorId(@PathParam("id") Long id) {
        try {
            return buscarTransacaoPorIDService.buscarTransacaoPorId(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
