package br.com.bb9leko.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "controle_transacoes")
public class ControleTransacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ticket", nullable = false)
    private String ticket;

    @Column(name = "dsc_estado", nullable = false)
    private String descricaoEstado;

    @Column(name = "mensagem_erro")
    private String mensagemErro;

    @Column(name = "dt_criacao", nullable = false)
    private LocalDateTime dataCriacao;

    public ControleTransacao() {}

    public ControleTransacao(String ticket, String descricaoEstado) {
        this.ticket = ticket;
        this.descricaoEstado = descricaoEstado;
        this.dataCriacao = LocalDateTime.now();
    }

    public ControleTransacao(String ticket, String descricaoEstado, String mensagemErro) {
        this.ticket = ticket;
        this.descricaoEstado = descricaoEstado;
        this.mensagemErro = mensagemErro;
        this.dataCriacao = LocalDateTime.now();
    }

    // Getters
    public Long getId() { return id; }
    public String getTicket() { return ticket; }
    public String getDescricaoEstado() { return descricaoEstado; }
    public String getMensagemErro() { return mensagemErro; }
    public LocalDateTime getDataCriacao() { return dataCriacao; }
}
