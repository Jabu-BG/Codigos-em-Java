package br.edu.dao.app;

import br.edu.dao.dao.ProdutoDAO;
import br.edu.dao.dao.ProdutoDAOImpl;
import br.edu.dao.infra.DatabaseInitializer;
import br.edu.dao.model.Produto;

import java.sql.SQLException;

/**
 * Programa executável usado na aula para demonstrar o CRUD.
 */
public final class Main {
    private Main() {
    }

    public static void main(String[] args) {
        try {
            DatabaseInitializer.inicializar();
            ProdutoDAO produtoDAO = new ProdutoDAOImpl();

            System.out.println("=== Classe DAO: JDBC + SQLite ===");

            // CREATE
            Produto teclado = produtoDAO.criar(
                    new Produto("Teclado mecânico", 249.90, 10));
            Produto rato = produtoDAO.criar(
                    new Produto("Rato sem fio", 89.90, 25));
            System.out.println("\n[CREATE]");
            System.out.println("Criado: " + teclado);
            System.out.println("Criado: " + rato);

            // READ
            System.out.println("\n[READ - buscar por id]");
            produtoDAO.buscarPorId(teclado.getId())
                    .ifPresentOrElse(
                            produto -> System.out.println("Encontrado: " + produto),
                            () -> System.out.println("Produto não encontrado."));

            System.out.println("\n[READ - listar todos]");
            produtoDAO.listarTodos().forEach(System.out::println);

            // UPDATE
            teclado.setPreco(229.90);
            teclado.setEstoque(8);
            boolean atualizado = produtoDAO.atualizar(teclado);
            System.out.println("\n[UPDATE]");
            System.out.println("Atualização realizada: " + atualizado);
            produtoDAO.buscarPorId(teclado.getId()).ifPresent(System.out::println);

            // DELETE
            boolean removido = produtoDAO.excluir(rato.getId());
            System.out.println("\n[DELETE]");
            System.out.println("Remoção realizada: " + removido);

            System.out.println("\n[ESTADO FINAL]");
            produtoDAO.listarTodos().forEach(System.out::println);
            System.out.println("\nBase de dados: dados/loja.db");
        } catch (SQLException | IllegalArgumentException e) {
            System.err.println("Erro na execução: " + e.getMessage());
            e.printStackTrace(System.err);
            System.exit(1);
        }
    }
}
