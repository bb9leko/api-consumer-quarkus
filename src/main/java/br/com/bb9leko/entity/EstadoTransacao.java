package br.com.bb9leko.enums;

public enum EstadoTransacao {
    EM_ANDAMENTO("Requisição em andamento"),
    FINALIZADA("Requisição finalizada"),
    ERRO("Erro capturado");

    private final String descricao;

    EstadoTransacao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
