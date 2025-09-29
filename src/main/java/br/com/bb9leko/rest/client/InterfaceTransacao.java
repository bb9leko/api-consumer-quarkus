package br.com.bb9leko.rest.client;

import jakarta.enterprise.context.Dependent;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import br.com.bb9leko.vo.Transacao;

import java.util.List;

@Dependent
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/")
@RegisterRestClient
public interface InterfaceTransacao {

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("transacao/listaTransacoes")
    List<Transacao> getTransacao(
            //@HeaderParam("Authorization") String authorization,
            //@QueryParam("filter") String dataEvento,
    );

    @GET
    @Path("transacao/buscarPorTicket")
    @Produces(MediaType.APPLICATION_JSON)
    List<Transacao> buscarPorTicket(@QueryParam("q") String ticket);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("transacao/insereTransacao")
    Response insereTransacao(Transacao dto);
//            @HeaderParam("Authorization") String authorization,
//            );

    @DELETE
    @Path("transacao/excluirTransacao/{id}")
    Response deletarTransacao(@PathParam("id") Long id);

    @GET
    @Path("transacao/buscarTransacaoPorId/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    Transacao buscarTransacaoPorId(@PathParam("id") Long id);

}
