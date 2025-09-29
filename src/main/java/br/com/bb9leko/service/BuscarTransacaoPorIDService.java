/*package br.com.bb9leko.service;

import br.com.bb9leko.rest.client.InterfaceTransacao;
import br.com.bb9leko.vo.Transacao;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class BuscarTransacaoPorIDService {

    @Inject
    @RestClient
    InterfaceTransacao interfaceTransacao;

    public Response findById(Long id) {
        try {
            Response response = interfaceTransacao.buscarTransacaoPorId(id);
            if (response.getStatus() == 200) {
                return response;
            } else {
                return Response.status(response.getStatus()).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }
}
*/