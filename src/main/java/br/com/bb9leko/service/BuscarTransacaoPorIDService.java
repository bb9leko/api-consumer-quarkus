package br.com.bb9leko.service;

import br.com.bb9leko.rest.client.InterfaceTransacao;
import br.com.bb9leko.vo.Transacao;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class BuscarTransacaoPorIDService {

    @Inject
    @RestClient
    InterfaceTransacao interfaceTransacao;

    public Transacao buscarTransacaoPorId(@PathParam("id") Long id) {
        try {
            return interfaceTransacao.buscarTransacaoPorId(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
