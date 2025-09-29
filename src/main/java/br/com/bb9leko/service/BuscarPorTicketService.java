/*package br.com.bb9leko.service;

import br.com.bb9leko.rest.client.InterfaceTransacao;
import br.com.bb9leko.vo.Transacao;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ApplicationScoped
public class BuscarPorTicketService {

    @Inject
    @RestClient
    InterfaceTransacao interfaceTransacao;

    public List<Transacao> buscarPorTicket(String ticket) {
        List<Transacao> listaTransacoes = new ArrayList<>();
        try {
            listaTransacoes = interfaceTransacao.buscarPorTicket(ticket);

        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
        return listaTransacoes;
    }
}

*/