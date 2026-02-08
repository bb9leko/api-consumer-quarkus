package br.com.bb9leko.service;

import br.com.bb9leko.rest.client.InterfaceTransacao;
import br.com.bb9leko.vo.Transacao;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@ApplicationScoped
public class BuscarPorTicketService {

    private static final Logger LOGGER = Logger.getLogger(BuscarPorTicketService.class.getName());

    @Inject
    @RestClient
    InterfaceTransacao interfaceTransacao;

    public List<Transacao> buscarPorTicket(String ticket) {
        try {
            return interfaceTransacao.buscarPorTicket(ticket);
        } catch (Exception e) {
            //e.printStackTrace();
            LOGGER.log(Level.WARNING, "Erro ao buscar por ticket: " + ticket, e);
            return Collections.emptyList();
        }
    }

}

