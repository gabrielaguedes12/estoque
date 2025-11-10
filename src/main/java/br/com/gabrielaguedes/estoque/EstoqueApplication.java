package br.com.gabrielaguedes.estoque;

import org.springframework.boot.SpringApplication;  
import org.springframework.boot.autoconfigure.SpringBootApplication;
import br.com.gabrielaguedes.estoque.model.Produto;
import org.springframework.boot.CommandLineRunner; 

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class EstoqueApplication implements CommandLineRunner {

	private final List<Produto> produtos = new ArrayList<>();
	
    public static void main(String[] args) {
        SpringApplication.run(EstoqueApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        System.out.println("=== Sistema de Estoque - Feature 2 ===");

        while (continuar) {
            System.out.println("\n===== MENU PRINCIPAL =====");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Listar produtos");
            System.out.println("3 - Buscar produto por ID");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1 -> cadastrarProduto(scanner);
                case 2 -> listarProdutos();
                case 3 -> buscarProdutoPorId(scanner);
                case 4 -> {
                    System.out.println("Encerrando o sistema...");
                    continuar = false;
                }
                default -> System.out.println("⚠️ Opção inválida! Tente novamente.");
            }
        }

        scanner.close();
        System.exit(0);
    }

    private void cadastrarProduto(Scanner scanner) {
        System.out.println("\n=== Cadastro de Produto ===");

        System.out.print("ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        // Verifica se já existe produto com o mesmo ID
        for (Produto p : produtos) {
            if (p.getId() == id) {
                System.out.println("❌ Já existe um produto com esse ID!");
                return;
            }
        }

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Disponível? (true/false): ");
        boolean disponivel = Boolean.parseBoolean(scanner.nextLine());

        System.out.print("Preço: ");
        double preco = Double.parseDouble(scanner.nextLine());

        Produto produto = new Produto(id, nome, disponivel, preco);

        System.out.print("Produto em promoção? (true/false): ");
        boolean promocao = Boolean.parseBoolean(scanner.nextLine());
        produto.aplicarDescontoSePromocao(promocao);

        produtos.add(produto);
        System.out.println("Produto cadastrado com sucesso!");
    }

    private void listarProdutos() {
        System.out.println("\n=== Lista de Produtos ===");

        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado ainda.");
            return;
        }

        for (Produto p : produtos) {
            System.out.println(p);
        }
    }

    private void buscarProdutoPorId(Scanner scanner) {
        System.out.print("\nDigite o ID do produto: ");
        int idBusca = Integer.parseInt(scanner.nextLine());

        boolean encontrado = false;

        for (Produto p : produtos) {
            if (p.getId() == idBusca) {
                System.out.println("Produto encontrado:");
                System.out.println(p);
                encontrado = true;
                break; // sai do laço ao encontrar o produto
            }
        }

        if (!encontrado) {
            System.out.println("❌ Produto não encontrado.");
        }
    }
}