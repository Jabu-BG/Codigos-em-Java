package br.edu.dao.dao;

import br.edu.dao.model.Produto;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * Contrato de persistência de Produto.
 * A aplicação conhece esta interface, não os detalhes de JDBC ou SQL.
 */
public interface ProdutoDAO {
    Produto criar(Produto produto) throws SQLException;

    Optional<Produto> buscarPorId(long id) throws SQLException;

    List<Produto> listarTodos() throws SQLException;

    boolean atualizar(Produto produto) throws SQLException;

    boolean excluir(long id) throws SQLException;
}
