package br.com.bb9leko.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import br.com.bb9leko.rest.client.InterfaceTransacao;

@ApplicationScoped
public class DeletarTransacaoService {

    @Inject
    @RestClient
    InterfaceTransacao interfaceTransacao;

    public Response deletarTransacao(@PathParam("id") Long id) {
        try{
            return interfaceTransacao.deletarTransacao(id);
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro ao deletar a transação").build();
        }
    }
}
