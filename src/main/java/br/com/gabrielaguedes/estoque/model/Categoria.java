package br.com.gabrielaguedes.estoque.model;

public class Categoria {

    private String nome;
    private String descricao;

    public Categoria() {}

    public Categoria(String nome) {
        this.nome = nome;
    }

    public Categoria(String nome, String descricao) {
        this(nome);
        this.descricao = descricao;
    }

    public String getNome() { return nome; }
    public String getDescricao() { return descricao; }

    @Override
    public String toString() {
        return nome + (descricao != null && !descricao.isBlank()
                ? " - " + descricao
                : "");
    }
}
