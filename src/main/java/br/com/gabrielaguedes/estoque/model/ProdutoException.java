package br.com.gabrielaguedes.estoque.model;

public class ProdutoException extends RuntimeException {
    public ProdutoException(String mensagem) {
        super(mensagem);
    }
}
