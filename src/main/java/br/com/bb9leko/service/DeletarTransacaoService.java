/*package br.com.bb9leko.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import br.com.bb9leko.rest.client.InterfaceTransacao;

@ApplicationScoped
public class DeletarTransacaoService {

    @Inject
    @RestClient
    InterfaceTransacao interfaceTransacao;

    public boolean deletarPorId(Long id) {
        try {
            Response response = interfaceTransacao.deletarTransacao(id);
            if (response.getStatus() == 200 || response.getStatus() == 204) {
                return true;
            } else if (response.getStatus() == 404) {
                return false;
            } else {
                throw new RuntimeException("Erro ao deletar transação: " + response.getStatus());
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao deletar transação: " + e.getMessage(), e);
        }
    }
}
*/