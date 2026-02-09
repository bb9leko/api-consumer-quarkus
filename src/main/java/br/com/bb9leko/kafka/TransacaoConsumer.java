package br.com.bb9leko.kafka;

import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Incoming;

@ApplicationScoped
public class TransacaoConsumer {

    @Incoming("transacoes-in")
    public void processar(String mensagem) {
        Log.infof(">>> Mensagem recebida do Kafka: %s", mensagem);
        // Aqui você pode salvar no banco, processar, etc.
    }
}