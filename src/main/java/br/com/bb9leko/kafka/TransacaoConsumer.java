package br.com.bb9leko.kafka;

import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Incoming;

@ApplicationScoped
public class TransacaoConsumer {
    /**
     * Processa a mensagem recebida do Kafka.
     * Subclasses devem garantir que o processamento seja
     * idempotente e thread-safe.
     *
     * @param mensagem mensagem recebida do Kafka
     */
    @Incoming("transacoes-in")
    public void processar(final String mensagem) {
        Log.infof(">>> Mensagem recebida do Kafka: %s",
                mensagem);
        // Aqui você pode salvar no banco, processar, etc.
    }
}

