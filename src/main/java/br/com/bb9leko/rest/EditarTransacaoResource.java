package br.com.bb9leko.rest;

import br.com.bb9leko.service.EditarTransacaoService;
import br.com.bb9leko.vo.Transacao;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/transacao")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EditarTransacaoResource {

    @Inject
    EditarTransacaoService service;

    @PUT
    @Path("/editarTransacao/{id}")
    public Response editarTransacao(@PathParam("id") Long id, Transacao dto) {
        return service.editarTransacao(id, dto);
    }
}
