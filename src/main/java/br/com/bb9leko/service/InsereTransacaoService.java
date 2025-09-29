/*package br.com.bb9leko.service;

import br.com.bb9leko.rest.client.InterfaceTransacao;
import br.com.bb9leko.vo.Transacao;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class InsereTransacaoService{

    @Inject
    @RestClient
    InterfaceTransacao interfaceTransacao;

    public Response enviarTransacao(Transacao dto) {
        try {
            Response response = interfaceTransacao.insereTransacao(dto);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }
}
*/