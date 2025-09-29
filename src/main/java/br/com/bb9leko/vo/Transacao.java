package br.com.bb9leko.vo;

public class Transacao {

    public int id;

    public String dataEvento;

    public String corretora;

    public String classificacaoAtivo;

    public String ticket;

    public String compraOUVenda;

    public int quantidade;

    public double valorUnitario;

    public double valorTotal;

    public double valorTaxaLiquidacao;

    public double valorTaxasEmolumentos;

    public double valorImpostos;

    public double outrosValoresCobrados;

    public double valorCorretagem;

    public double valorTotalComCustosEDespesas;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(String dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getCorretora() {
        return corretora;
    }

    public void setCorretora(String corretora) {
        this.corretora = corretora;
    }

    public String getClassificacaoAtivo() {
        return classificacaoAtivo;
    }

    public void setClassificacaoAtivo(String classificacaoAtivo) {
        this.classificacaoAtivo = classificacaoAtivo;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getCompraOUVenda() {
        return compraOUVenda;
    }

    public void setCompraOUVenda(String compraOUVenda) {
        this.compraOUVenda = compraOUVenda;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public double getValorTaxaLiquidacao() {
        return valorTaxaLiquidacao;
    }

    public void setValorTaxaLiquidacao(double valorTaxaLiquidacao) {
        this.valorTaxaLiquidacao = valorTaxaLiquidacao;
    }

    public double getValorTaxasEmolumentos() {
        return valorTaxasEmolumentos;
    }

    public void setValorTaxasEmolumentos(double valorTaxasEmolumentos) {
        this.valorTaxasEmolumentos = valorTaxasEmolumentos;
    }

    public double getValorImpostos() {
        return valorImpostos;
    }

    public void setValorImpostos(double valorImpostos) {
        this.valorImpostos = valorImpostos;
    }

    public double getOutrosValoresCobrados() {
        return outrosValoresCobrados;
    }

    public void setOutrosValoresCobrados(double outrosValoresCobrados) {
        this.outrosValoresCobrados = outrosValoresCobrados;
    }

    public double getValorCorretagem() {
        return valorCorretagem;
    }

    public void setValorCorretagem(double valorCorretagem) {
        this.valorCorretagem = valorCorretagem;
    }

    public double getValorTotalComCustosEDespesas() {
        return valorTotalComCustosEDespesas;
    }

    public void setValorTotalComCustosEDespesas(double valorTotalComCustosEDespesas) {
        this.valorTotalComCustosEDespesas = valorTotalComCustosEDespesas;
    }

    @Override
    public String toString() {
        return "Transacao{" +
                "id=" + id +
                ", dataEvento='" + dataEvento + '\'' +
                ", corretora='" + corretora + '\'' +
                ", classificacaoAtivo='" + classificacaoAtivo + '\'' +
                ", ticket='" + ticket + '\'' +
                ", compraOUVenda='" + compraOUVenda + '\'' +
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
