package br.com.gabrielaguedes.estoque;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import br.com.gabrielaguedes.estoque.model.Produto;
import org.springframework.boot.CommandLineRunner; 

import java.util.Scanner;

@SpringBootApplication
public class EstoqueApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(EstoqueApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Cadastro de Produto (Feature 1) ===");

        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Disponível? (true/false): ");
        boolean disponivel = Boolean.parseBoolean(scanner.nextLine());

        System.out.print("Preço: ");
        double preco = scanner.nextDouble();
        scanner.nextLine();

        Produto produto = new Produto(id, nome, disponivel, preco);

        System.out.print("Produto em promoção? (true/false): ");
        boolean promocao = Boolean.parseBoolean(scanner.nextLine());

        produto.aplicarDescontoSePromocao(promocao);

        System.out.println("\n--- Produto cadastrado ---");
        System.out.println(produto);

        System.out.println("\nExecução da Feature 1 concluída.");
        scanner.close();
        System.exit(0);
    }
}
