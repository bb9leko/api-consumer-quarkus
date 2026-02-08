package br.com.bb9leko.repository;

import br.com.bb9leko.entity.ControleTransacao;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ControleTransacaoRepository implements PanacheRepository<ControleTransacao> {

    // Retorna o estado mais recente do ticket
    public Optional<ControleTransacao> findUltimoEstadoByTicket(String ticket) {
        return find("ticket = ?1 ORDER BY dataCriacao DESC", ticket)
                .firstResultOptional();
    }

    // Retorna todo o histórico do ticket
    public List<ControleTransacao> findHistoricoByTicket(String ticket) {
        return find("ticket = ?1 ORDER BY dataCriacao ASC", ticket).list();
    }

    // Retorna o primeiro registro (para calcular timeout)
    public Optional<ControleTransacao> findPrimeiroEstadoByTicket(String ticket) {
        return find("ticket = ?1 ORDER BY dataCriacao ASC", ticket)
                .firstResultOptional();
    }
}
