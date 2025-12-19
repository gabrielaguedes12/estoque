package br.com.gabrielaguedes.estoque.model;

public abstract class Produto implements Descontavel {

    private int id;
    private String nome;
    private boolean disponivel;
    private double preco;

    private Categoria categoria;
    private TipoProduto tipo;

    public Produto(int id, String nome, boolean disponivel, double preco,
                   Categoria categoria, TipoProduto tipo) {
        this.id = id;
        this.nome = nome;
        this.disponivel = disponivel;
        this.preco = preco;
        this.categoria = categoria;
        this.tipo = tipo;
    }

    public abstract boolean isValido();

    public int getId() { return id; }
    public double getPreco() { return preco; }
    public String getNome() { return nome; }
    public Categoria getCategoria() { return categoria; }
    public TipoProduto getTipo() { return tipo; }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", precoFinal=" + String.format("%.2f", calcularPrecoFinal()) +
                ", categoria=" + categoria +
                ", tipo=" + tipo +
                '}';
    }
}
