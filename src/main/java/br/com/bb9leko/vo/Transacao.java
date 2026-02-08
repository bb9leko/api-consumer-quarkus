package br.com.bb9leko.vo;


import jakarta.json.bind.annotation.JsonbDateFormat;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Transacao {

    @Schema(hidden = true)
    private Long id;

    @JsonbDateFormat("dd/MM/yyyy")
    private LocalDate dataEvento;

    private String corretora;

    private String classificacaoAtivo;

    private String ticket;

    private String compraOUVenda;

    private BigDecimal quantidade;

    private BigDecimal valorUnitario;

    @Schema(hidden = true)
    private BigDecimal valorTotal;

    private BigDecimal valorTaxaLiquidacao;

    private BigDecimal valorTaxasEmolumentos;

    private BigDecimal valorImpostos;

    private BigDecimal outrosValoresCobrados;

    private BigDecimal valorCorretagem;

    @Schema(hidden = true)
    private BigDecimal valorTotalComCustosEDespesas;

    public Transacao() {
    }

    public Transacao(Transacao transacao) {
        this.id = transacao.getId();
        this.dataEvento = transacao.getDataEvento();
        this.corretora = transacao.getCorretora();
        this.classificacaoAtivo = transacao.getClassificacaoAtivo();
        this.ticket = transacao.getTicket();
        this.compraOUVenda = transacao.getCompraOUVenda();
        this.quantidade = transacao.getQuantidade();
        this.valorUnitario = transacao.getValorUnitario();
        this.valorTotal = transacao.getValorTotal();
        this.valorTaxaLiquidacao = transacao.getValorTaxaLiquidacao();
        this.valorTaxasEmolumentos = transacao.getValorTaxasEmolumentos();
        this.valorImpostos = transacao.getValorImpostos();
        this.outrosValoresCobrados = transacao.getOutrosValoresCobrados();
        this.valorCorretagem = transacao.getValorCorretagem();
        this.valorTotalComCustosEDespesas = transacao.getValorTotalComCustosEDespesas();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDate getDataEvento() { return dataEvento; }
    public void setDataEvento(LocalDate dataEvento) { this.dataEvento = dataEvento; }

    public String getCorretora() { return corretora; }
    public void setCorretora(String corretora) { this.corretora = corretora; }

    public String getClassificacaoAtivo() { return classificacaoAtivo; }
    public void setClassificacaoAtivo(String classificacaoAtivo) { this.classificacaoAtivo = classificacaoAtivo; }

    public String getTicket() { return ticket; }
    public void setTicket(String ticket) { this.ticket = ticket; }

    public String getCompraOUVenda() { return compraOUVenda; }
    public void setCompraOUVenda(String compraOUVenda) { this.compraOUVenda = compraOUVenda; }

    public BigDecimal getQuantidade() { return quantidade; }
    public void setQuantidade(BigDecimal quantidade) { this.quantidade = quantidade; }

    public BigDecimal getValorUnitario() { return valorUnitario; }
    public void setValorUnitario(BigDecimal valorUnitario) { this.valorUnitario = valorUnitario; }

    public BigDecimal getValorTotal() { return valorTotal; }
    public void setValorTotal(BigDecimal valorTotal) { this.valorTotal = valorTotal; }

    public BigDecimal getValorTaxaLiquidacao() { return valorTaxaLiquidacao; }
    public void setValorTaxaLiquidacao(BigDecimal valorTaxaLiquidacao) { this.valorTaxaLiquidacao = valorTaxaLiquidacao; }

    public BigDecimal getValorTaxasEmolumentos() { return valorTaxasEmolumentos; }
    public void setValorTaxasEmolumentos(BigDecimal valorTaxasEmolumentos) { this.valorTaxasEmolumentos = valorTaxasEmolumentos; }

    public BigDecimal getValorImpostos() { return valorImpostos; }
    public void setValorImpostos(BigDecimal valorImpostos) { this.valorImpostos = valorImpostos; }

    public BigDecimal getOutrosValoresCobrados() { return outrosValoresCobrados; }
    public void setOutrosValoresCobrados(BigDecimal outrosValoresCobrados) { this.outrosValoresCobrados = outrosValoresCobrados; }

    public BigDecimal getValorCorretagem() { return valorCorretagem; }
    public void setValorCorretagem(BigDecimal valorCorretagem) { this.valorCorretagem = valorCorretagem; }

    public BigDecimal getValorTotalComCustosEDespesas() { return valorTotalComCustosEDespesas; }
    public void setValorTotalComCustosEDespesas(BigDecimal valorTotalComCustosEDespesas) { this.valorTotalComCustosEDespesas = valorTotalComCustosEDespesas; }
}
