package br.com.gabrielaguedes.estoque.model;

public class ProdutoPromocional extends Produto {

    private double percentualDesconto;

    public ProdutoPromocional(int id, String nome, boolean disponivel, double preco,
                              Categoria categoria, TipoProduto tipo,
                              double percentualDesconto) {
        super(id, nome, disponivel, preco, categoria, tipo);
        this.percentualDesconto = percentualDesconto;
    }

    @Override
    public boolean isValido() {
        return percentualDesconto > 0 && percentualDesconto < 1;
    }

    @Override
    public double calcularPrecoFinal() {
        return getPreco() - (getPreco() * percentualDesconto);
    }
}
