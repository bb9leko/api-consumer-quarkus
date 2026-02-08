package br.com.bb9leko.service;

import br.com.bb9leko.entity.TransacaoEntity;
import br.com.bb9leko.repository.TransacaoRepository;
import br.com.bb9leko.rest.client.InterfaceTransacao;
import br.com.bb9leko.vo.Transacao;
import io.quarkus.logging.Log;
import io.quarkus.vertx.ConsumeEvent;
import io.smallrye.common.annotation.Blocking;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@ApplicationScoped
public class BuscarTransacaoEPersistirService {

    private static final Logger LOGGER = Logger.getLogger(BuscarTransacaoEPersistirService.class.getName());

    @Inject
    @RestClient
    InterfaceTransacao interfaceTransacao;

    @Inject
    TransacaoRepository transacaoRepository;

    @Blocking
    @ConsumeEvent("buscarTransacaoEPersistir")
    public void buscarEPersistir (String ticket) {

        try {
            Log.info("Buscando transações para: " + ticket);

            // Chamada ao endpoint externo acontece AQUI
            List<Transacao> transacoes = interfaceTransacao.buscarPorTicket(ticket);

            persistir(transacoes);

        } catch (Exception e) {
            Log.error("Erro: " + e.getMessage(), e);
        }
    }
    @Transactional
    public void persistir(List<Transacao> transacoes) {
        Log.info("Persistindo " + transacoes.size() + " transações");

        for (Transacao transacao : transacoes) {
            TransacaoEntity entity = new TransacaoEntity(transacao);
            transacaoRepository.persist(entity);
        }
    }
}