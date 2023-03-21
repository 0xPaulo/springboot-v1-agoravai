package br.com.springboot.model;

public enum Sexo {
    MACULINO("Masculino"),
    FEMININO("Feminino");

    private String descricao;

    Sexo(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao(){
        return this.descricao;
    }
}
