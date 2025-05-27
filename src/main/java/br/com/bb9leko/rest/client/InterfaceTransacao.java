package br.com.bb9leko.rest.client;

import jakarta.enterprise.context.Dependent;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
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

//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("insereTransacao")
//    InsereTransacaoResponse insereTransacao(
//            @HeaderParam("Authorization") String authorization,
//            );

}
