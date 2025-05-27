package br.com.bb9leko.rest;

import br.com.bb9leko.rest.client.InterfaceTransacao;
import br.com.bb9leko.service.TransacaoService;
import br.com.bb9leko.vo.Transacao;
import io.vertx.core.impl.logging.Logger;
import io.vertx.core.impl.logging.LoggerFactory;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.ArrayList;
import java.util.List;

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
public class ListarTransacoesResource {

    private static final Logger LOG = LoggerFactory.getLogger(ListarTransacoesResource.class);

    @Inject
    TransacaoService transacaoService;

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("consultaTransacoes")
    public List<Transacao> listar() {
        List<Transacao> transacoes = transacaoService.buscarTransacoes();
        return transacoes;
    }
}
