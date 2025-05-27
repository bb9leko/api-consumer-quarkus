package br.com.bb9leko.service;

import br.com.bb9leko.rest.client.InterfaceTransacao;
import br.com.bb9leko.vo.Transacao;
import io.vertx.core.impl.logging.Logger;
import io.vertx.core.impl.logging.LoggerFactory;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class TransacaoService {

    private static final Logger LOG = LoggerFactory.getLogger(TransacaoService.class);

    @Inject
    @RestClient
    InterfaceTransacao interfaceTransacao;

    public List<Transacao> buscarTransacoes() {
        LOG.debug("Lista Transações");
        List<Transacao> listaTransacoes = new ArrayList<>();
        try {
            listaTransacoes = interfaceTransacao.getTransacao();
        } catch (Exception e) {
            e.printStackTrace();
            // Aqui você pode tratar o erro, logar ou lançar uma exceção personalizada
        }
        return listaTransacoes;
    }
}