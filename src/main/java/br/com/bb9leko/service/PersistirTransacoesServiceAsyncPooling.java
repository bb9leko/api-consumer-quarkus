package br.com.bb9leko.service;

import br.com.bb9leko.entity.ControleTransacao;
import br.com.bb9leko.entity.TransacaoEntity;
import br.com.bb9leko.enums.EstadoTransacao;
import br.com.bb9leko.repository.ControleTransacaoRepository;
import br.com.bb9leko.repository.TransacaoRepository;
import br.com.bb9leko.vo.Transacao;
import br.com.bb9leko.vo.TransacaoComTicket;
import io.quarkus.logging.Log;
import io.quarkus.vertx.ConsumeEvent;
import io.smallrye.common.annotation.Blocking;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class PersistirTransacoesServiceAsyncPooling {

    @Inject
    TransacaoRepository transacaoRepository;

    @Inject
    ControleTransacaoRepository controleRepository;

    @Blocking
    @ConsumeEvent("persistirTransacoesAsync")
    @Transactional
    public void persistir(TransacaoComTicket payload) {
        Log.info("Persistindo " + payload.transacoes.size() + " transações para: " + payload.ticket);

        try {
            for (Transacao transacao : payload.transacoes) {
                TransacaoEntity entity = new TransacaoEntity(transacao);
                transacaoRepository.persist(entity);
            }

            // Insere NOVO registro com estado FINALIZADA
            inserirNovoEstado(payload.ticket, EstadoTransacao.FINALIZADA, null);

        } catch (Exception e) {
            Log.error("Erro ao persistir: " + e.getMessage(), e);
            inserirNovoEstado(payload.ticket, EstadoTransacao.ERRO, e.getMessage());
        }
    }

    @Blocking
    @ConsumeEvent("erroTransacao")
    @Transactional
    public void tratarErro(BuscarTransacaoPorTicketService.ErroTransacao erro) {
        Log.error("Tratando erro para ticket: " + erro.ticket);
        inserirNovoEstado(erro.ticket, EstadoTransacao.ERRO, erro.mensagem);
    }

    private void inserirNovoEstado(String ticket, EstadoTransacao estado, String mensagemErro) {
        ControleTransacao novoControle = new ControleTransacao(
                ticket,
                estado.getDescricao(),
                mensagemErro
        );
        controleRepository.persist(novoControle);
        Log.info("Novo estado inserido: " + ticket + " -> " + estado.getDescricao());
    }
}
