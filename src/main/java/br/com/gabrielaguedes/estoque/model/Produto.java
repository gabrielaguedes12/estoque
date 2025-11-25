package br.com.gabrielaguedes.estoque.model;

public class Produto {
	private int id;
	private String nome;
	private boolean disponivel;
	private double preco;

    private Categoria categoria;
    private TipoProduto tipo;

	public Produto() {}
	
	public Produto(int id, String nome, boolean disponivel, double preco) {
		this.id = id;
		this.nome = nome;
		this.disponivel = disponivel;
		this.preco = preco;
	}
    public Produto(int id, String nome, boolean disponivel, double preco,
                   Categoria categoria, TipoProduto tipo) {
        this(id, nome, disponivel, preco);
        this.categoria = categoria;
        this.tipo = tipo;
    }
	
	 public int getId() { return id; }
	    public void setId(int id) { this.id = id; }

	    public String getNome() { return nome; }
	    public void setNome(String nome) { this.nome = nome; }

	    public boolean isDisponivel() { return disponivel; }
	    public void setDisponivel(boolean disponivel) { this.disponivel = disponivel; }

	    public double getPreco() { return preco; }
	    public void setPreco(double preco) { this.preco = preco; }

    public Categoria getCategoria() { return categoria; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }

    public TipoProduto getTipo() { return tipo; }
    public void setTipo(TipoProduto tipo) { this.tipo = tipo; }

	    public void aplicarDescontoSePromocao(boolean promocao) {
	        System.out.println("Aplicando regra de desconto...");
	        double novoPreco = calcularDesconto(promocao);
	        this.preco = novoPreco;

	        if (this.preco <= 0) {
	            this.disponivel = false;
	        }
	    }
	    private double calcularDesconto(boolean promocao) {
	        if (!promocao) return this.preco;
	        double desconto = this.preco > 100 ? 0.10 : 0.05;
	        return this.preco - (this.preco * desconto);
	    }

	    @Override
	    public String toString() {
	        return "Produto{" +
	                "id=" + id +
	                ", nome='" + nome + '\'' +
	                ", disponivel=" + disponivel +
	                ", preco=" + String.format("%.2f", preco) +
                    ", categoria=" + categoria +
                    ", tipo=" + tipo +
	                '}';
	    }
	}

