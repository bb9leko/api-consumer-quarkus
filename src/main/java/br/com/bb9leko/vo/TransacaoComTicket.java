package br.com.bb9leko.vo;

import java.util.List;

public class TransacaoComTicket {
    public String ticket;
    public List<Transacao> transacoes;

    public TransacaoComTicket() {}

    public TransacaoComTicket(String ticket, List<Transacao> transacoes) {
        this.ticket = ticket;
        this.transacoes = transacoes;
    }
}
