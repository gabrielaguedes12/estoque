package br.com.gabrielaguedes.estoque.model;

public class Produto {
	private int id;
	private String nome;
	private boolean disponivel;
	private double preco;
	
	public Produto() {}
	
	public Produto(int id, String nome, boolean disponivel, double preco) {
		this.id = id;
		this.nome = nome;
		this.disponivel = disponivel;
		this.preco = preco;
	}
	
	 public int getId() { return id; }
	    public void setId(int id) { this.id = id; }

	    public String getNome() { return nome; }
	    public void setNome(String nome) { this.nome = nome; }

	    public boolean isDisponivel() { return disponivel; }
	    public void setDisponivel(boolean disponivel) { this.disponivel = disponivel; }

	    public double getPreco() { return preco; }
	    public void setPreco(double preco) { this.preco = preco; }
	    
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
	                '}';
	    }
	}

