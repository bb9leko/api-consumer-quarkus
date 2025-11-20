package br.com.bb9leko.rest;

import br.com.bb9leko.service.InsereTransacaoService;
import br.com.bb9leko.vo.Transacao;
import io.vertx.core.impl.logging.Logger;
import io.vertx.core.impl.logging.LoggerFactory;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/transacao/insereTransacao")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class InsereTransacaoResource {

    private static final Logger LOG = LoggerFactory.getLogger(ListarTransacoesResource.class);

    @Inject
    InsereTransacaoService insereTransacaoService;

    @POST
    public Response inserirTransacao(Transacao dto) {
        try {
            Response response = insereTransacaoService.insereTransacaoService(dto);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }
}
