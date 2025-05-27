package br.com.bb9leko.vo;

public class Transacao {
    public String classificacaoAtivo;
    public String compraOUVenda;
    public String corretora;
    public String dataEvento;
    public int id;
    public int quantidade;
    public String ticket;
    public double valorCorretagem;
    public double valorTaxasEmolumentos;
    public double valorTotal;
    public double valorUnitario;

    public String getClassificacaoAtivo() {
        return classificacaoAtivo;
    }

    public void setClassificacaoAtivo(String classificacaoAtivo) {
        this.classificacaoAtivo = classificacaoAtivo;
    }

    public String getCompraOUVenda() {
        return compraOUVenda;
    }

    public void setCompraOUVenda(String compraOUVenda) {
        this.compraOUVenda = compraOUVenda;
    }

    public String getCorretora() {
        return corretora;
    }

    public void setCorretora(String corretora) {
        this.corretora = corretora;
    }

    public String getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(String dataEvento) {
        this.dataEvento = dataEvento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public double getValorCorretagem() {
        return valorCorretagem;
    }

    public void setValorCorretagem(double valorCorretagem) {
        this.valorCorretagem = valorCorretagem;
    }

    public double getValorTaxasEmolumentos() {
        return valorTaxasEmolumentos;
    }

    public void setValorTaxasEmolumentos(double valorTaxasEmolumentos) {
        this.valorTaxasEmolumentos = valorTaxasEmolumentos;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    @Override
    public String toString() {
        return "{" +
                "classificacaoAtivo='" + classificacaoAtivo + '\'' +
                ", compraOUVenda='" + compraOUVenda + '\'' +
                ", corretora='" + corretora + '\'' +
                ", dataEvento='" + dataEvento + '\'' +
                ", id=" + id +
                ", quantidade=" + quantidade +
                ", ticket='" + ticket + '\'' +
                ", valorCorretagem=" + valorCorretagem +
                ", valorTaxasEmolumentos=" + valorTaxasEmolumentos +
                ", valorTotal=" + valorTotal +
                ", valorUnitario=" + valorUnitario +
                '}';
    }
}
