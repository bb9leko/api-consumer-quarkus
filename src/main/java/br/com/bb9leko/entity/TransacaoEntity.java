package br.com.bb9leko.entity;

import br.com.bb9leko.vo.ClassificacaoAtivo;
import br.com.bb9leko.vo.Evento;
import br.com.bb9leko.vo.Transacao;
import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "Transacoes")
public class TransacaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonbDateFormat("dd/MM/yyyy")
    private LocalDate dataEvento;

    private String corretora;

    @Enumerated(EnumType.STRING)
    @Column(name = "classificacaoativo")
    private ClassificacaoAtivo classificacaoAtivo;

    private String ticket;

    @Enumerated(EnumType.STRING)
    private Evento compraOUVenda;

    @Column(precision = 38, scale = 2)
    private BigDecimal quantidade;

    private BigDecimal valorUnitario;

    @Column(precision = 38, scale = 2)
    private BigDecimal valorTotal;

    @Column(precision = 38, scale = 2)
    private BigDecimal valorTaxaLiquidacao;

    private BigDecimal valorTaxasEmolumentos;

    private BigDecimal valorImpostos;

    private BigDecimal outrosValoresCobrados;

    private BigDecimal valorCorretagem;

    private BigDecimal valorTotalComCustosEDespesas;

    public TransacaoEntity() {
    }

    public TransacaoEntity(Transacao vo) {
        this.dataEvento = vo.getDataEvento();
        this.corretora = vo.getCorretora();
        this.classificacaoAtivo = ClassificacaoAtivo.valueOf(vo.getClassificacaoAtivo());
        this.ticket = vo.getTicket();
        this.compraOUVenda = Evento.valueOf(vo.getCompraOUVenda());
        this.quantidade = vo.getQuantidade();
        this.valorUnitario = vo.getValorUnitario();
        this.valorTaxaLiquidacao = vo.getValorTaxaLiquidacao();
        this.valorTaxasEmolumentos = vo.getValorTaxasEmolumentos();
        this.valorImpostos = vo.getValorImpostos();
        this.outrosValoresCobrados = vo.getOutrosValoresCobrados();
        this.valorCorretagem = vo.getValorCorretagem();
    }

    @PrePersist
    @PreUpdate
    private void calcularValorTotalComCustosEDespesas() {
        if (this.valorUnitario != null && this.quantidade != null) {
            this.valorTotal = this.valorUnitario.multiply(this.quantidade);

            this.valorTotalComCustosEDespesas = this.valorTotal
                    .add(this.valorTaxaLiquidacao != null ? this.valorTaxaLiquidacao : BigDecimal.ZERO)
                    .add(this.valorTaxasEmolumentos != null ? this.valorTaxasEmolumentos : BigDecimal.ZERO)
                    .add(this.valorImpostos != null ? this.valorImpostos : BigDecimal.ZERO)
                    .add(this.outrosValoresCobrados != null ? this.outrosValoresCobrados : BigDecimal.ZERO)
                    .add(this.valorCorretagem != null ? this.valorCorretagem : BigDecimal.ZERO);
        }
    }

    // Getters e Setters
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public LocalDate getDataEvento() { return dataEvento; }
    public void setDataEvento(LocalDate dataEvento) { this.dataEvento = dataEvento; }

    public String getCorretora() { return corretora; }
    public void setCorretora(String corretora) { this.corretora = corretora; }

    public ClassificacaoAtivo getClassificacaoAtivo() { return classificacaoAtivo; }
    public void setClassificacaoAtivo(ClassificacaoAtivo classificacaoAtivo) { this.classificacaoAtivo = classificacaoAtivo; }

    public String getTicket() { return ticket; }
    public void setTicket(String ticket) { this.ticket = ticket; }

    public Evento getCompraOUVenda() { return compraOUVenda; }
    public void setCompraOUVenda(Evento compraOUVenda) { this.compraOUVenda = compraOUVenda; }

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

    @Override
    public String toString() {
        return "TransacaoEntity{" +
                "id=" + id +
                ", dataEvento=" + dataEvento +
                ", corretora='" + corretora + '\'' +
                ", classificacaoAtivo=" + classificacaoAtivo +
                ", ticket='" + ticket + '\'' +
                ", compraOUVenda=" + compraOUVenda +
                ", quantidade=" + quantidade +
                ", valorUnitario=" + valorUnitario +
                ", valorTotal=" + valorTotal +
                ", valorTaxaLiquidacao=" + valorTaxaLiquidacao +
                ", valorTaxasEmolumentos=" + valorTaxasEmolumentos +
                ", valorImpostos=" + valorImpostos +
                ", outrosValoresCobrados=" + outrosValoresCobrados +
                ", valorCorretagem=" + valorCorretagem +
                ", valorTotalComCustosEDespesas=" + valorTotalComCustosEDespesas +
                '}';
    }
}
