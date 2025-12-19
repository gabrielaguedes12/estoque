package br.com.gabrielaguedes.estoque;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

import br.com.gabrielaguedes.estoque.model.*;

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
    public void run(String... args) {

        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Cadastrar produto promocional");
            System.out.println("2 - Listar produtos");
            System.out.println("3 - Buscar por ID");
            System.out.println("4 - Sair");
            System.out.print("Opção: ");

            int opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1 -> cadastrarProduto(scanner);
                case 2 -> listarProdutos();
                case 3 -> buscarProduto(scanner);
                case 4 -> continuar = false;
                default -> System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }

    private void cadastrarProduto(Scanner scanner) {

        try {
            System.out.print("ID: ");
            int id = Integer.parseInt(scanner.nextLine());

            for (Produto p : produtos) {
                if (p.getId() == id) {
                    throw new ProdutoException("ID já existente!");
                }
            }

            System.out.print("Nome: ");
            String nome = scanner.nextLine();

            System.out.print("Disponível (true/false): ");
            boolean disponivel = Boolean.parseBoolean(scanner.nextLine());

            System.out.print("Preço: ");
            double preco = Double.parseDouble(scanner.nextLine());

            System.out.print("Categoria: ");
            String nomeCategoria = scanner.nextLine();

            Categoria categoria = new Categoria(nomeCategoria);

            System.out.println("Tipos:");
            for (TipoProduto t : TipoProduto.values()) {
                System.out.println("- " + t);
            }

            System.out.print("Tipo: ");
            TipoProduto tipo = TipoProduto.valueOf(scanner.nextLine().toUpperCase());

            System.out.print("Desconto (ex: 0.20): ");
            double desconto = Double.parseDouble(scanner.nextLine());

            Produto produto = new ProdutoPromocional(
                    id, nome, disponivel, preco,
                    categoria, tipo, desconto
            );

            if (!produto.isValido()) {
                throw new ProdutoException("Desconto inválido.");
            }

            produtos.add(produto);
            System.out.println("Produto cadastrado com sucesso!");

        } catch (ProdutoException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private void listarProdutos() {
        produtos.forEach(System.out::println);
    }

    private void buscarProduto(Scanner scanner) {
        System.out.print("ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        for (Produto p : produtos) {
            if (p.getId() == id) {
                System.out.println(p);
                return;
            }
        }
        System.out.println("Produto não encontrado.");
    }
}
