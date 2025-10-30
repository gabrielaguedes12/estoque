Conceito:
O sistema é responsável por gerenciar o estoque de produtos, armazenando informações como ID, nome, disponibilidade e preço.
Essa estrutura é a base para futuras funcionalidades, como controle de entrada/saída, busca, filtros e relatórios.


Funcionalidades para implementar:
Cadastro de produto (com ID, nome, disponibilidade e preço)
Listagem dos produtos cadastrados
Atualização de informações de um produto
Remoção de produto do estoque

Estrutura do Projeto
src/
 └── main/
      ├── java/
      │    └── br/com/gabrielaguedes/estoque/
      │         ├── EstoqueApplication.java
      │         └── model/
      │              └── Produto.java
      └── resources/

Classes principais
Produto.java: representa um produto com atributos como id, nome, preco e disponivel.
EstoqueApplication.java: classe principal responsável pela execução do sistema.
