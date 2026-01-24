package br.com.bb9leko.service;

import br.com.bb9leko.rest.client.InterfaceTransacao;
import br.com.bb9leko.vo.Transacao;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class EditarTransacaoService {

    @Inject
    @RestClient
    InterfaceTransacao interfaceTransacao;

    public Response editarTransacao(Long id, Transacao dto) {
        try {
            Response response = interfaceTransacao.editarTransacao(id, dto);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro ao editar a transação").build();
        }
    }
}

