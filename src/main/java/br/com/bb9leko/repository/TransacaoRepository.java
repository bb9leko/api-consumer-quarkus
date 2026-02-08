package br.com.bb9leko.repository;

import br.com.bb9leko.entity.TransacaoEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.jboss.logging.Logger;

@ApplicationScoped
public class TransacaoRepository implements PanacheRepository<TransacaoEntity> {
}