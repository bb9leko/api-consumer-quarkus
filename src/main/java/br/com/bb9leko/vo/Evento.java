package br.com.bb9leko.vo;

public enum Evento {
    COMPRA("compra"),
    VENDA("venda"),
    BONIFICACAO("bonificacao"),
    DESDOBRAMENTO("desdobramento"),
    CONVERSAO("conversao"),;

    private final String descricao;

    Evento(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
