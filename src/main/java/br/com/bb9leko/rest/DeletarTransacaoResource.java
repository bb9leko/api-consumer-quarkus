package br.com.bb9leko.rest;

import br.com.bb9leko.rest.client.InterfaceTransacao;
import br.com.bb9leko.service.DeletarTransacaoService;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.core.MediaType;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/transacao")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DeletarTransacaoResource {

    @Inject
    DeletarTransacaoService deletarTransacaoService;

    @DELETE
    @Path("/excluirTransacao/{id}")
    public Response deletarTransacao(@PathParam("id") Long id) {
        try{
            return deletarTransacaoService.deletarTransacao(id);
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro ao deletar a transação").build();
        }
    }
}
