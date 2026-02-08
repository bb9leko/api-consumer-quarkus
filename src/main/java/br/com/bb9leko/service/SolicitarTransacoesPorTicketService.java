package br.com.bb9leko.service;

import br.com.bb9leko.entity.ControleTransacao;
import br.com.bb9leko.enums.EstadoTransacao;
import br.com.bb9leko.repository.ControleTransacaoRepository;
import io.quarkus.logging.Log;
import io.vertx.mutiny.core.eventbus.EventBus;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class SolicitarTransacoesPorTicketService {

    @Inject
    EventBus bus;

    @Inject
    ControleTransacaoRepository controleRepository;

    @Transactional
    public Long iniciarSolicitacao(String ticket) {
        Log.info("Criando controle para ticket: " + ticket);

        // Cria registro de controle com estado EM_ANDAMENTO
        ControleTransacao controle = new ControleTransacao(
                ticket,
                EstadoTransacao.EM_ANDAMENTO.getDescricao()
        );
        controleRepository.persist(controle);

        // Envia para processamento assíncrono
        bus.send("buscarTransacaoPorTicket", ticket);

        return controle.getId();
    }
}
