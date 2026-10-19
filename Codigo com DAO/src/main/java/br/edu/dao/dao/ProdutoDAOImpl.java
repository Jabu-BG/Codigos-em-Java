package br.edu.dao.dao;

import br.edu.dao.infra.ConexaoSQLite;
import br.edu.dao.model.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Implementação concreta de ProdutoDAO usando JDBC e SQLite.
 */
public class ProdutoDAOImpl implements ProdutoDAO {
    private static final String INSERT_SQL = """
            INSERT INTO produto (nome, preco, estoque)
            VALUES (?, ?, ?)
            """;

    private static final String SELECT_BY_ID_SQL = """
            SELECT id, nome, preco, estoque
            FROM produto
            WHERE id = ?
            """;

    private static final String SELECT_ALL_SQL = """
            SELECT id, nome, preco, estoque
            FROM produto
            ORDER BY id
            """;

    private static final String UPDATE_SQL = """
            UPDATE produto
            SET nome = ?, preco = ?, estoque = ?
            WHERE id = ?
            """;

    private static final String DELETE_SQL = "DELETE FROM produto WHERE id = ?";

    @Override
    public Produto criar(Produto produto) throws SQLException {
        validarProduto(produto);

        try (Connection connection = ConexaoSQLite.abrir();
             PreparedStatement statement = connection.prepareStatement(
                     INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {

            preencherDados(statement, produto);
            int affectedRows = statement.executeUpdate();
            if (affectedRows != 1) {
                throw new SQLException("A inserção não criou exatamente um produto.");
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    produto.setId(generatedKeys.getLong(1));
                    return produto;
                }
            }

            // Fallback para drivers que não expõem getGeneratedKeys().
            try (Statement lastIdStatement = connection.createStatement();
                 ResultSet resultSet = lastIdStatement.executeQuery("SELECT last_insert_rowid()")) {
                if (resultSet.next()) {
                    produto.setId(resultSet.getLong(1));
                    return produto;
                }
            }
        }

        throw new SQLException("Não foi possível obter o id gerado para o produto.");
    }

    @Override
    public Optional<Produto> buscarPorId(long id) throws SQLException {
        try (Connection connection = ConexaoSQLite.abrir();
             PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID_SQL)) {
            statement.setLong(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return Optional.of(mapear(resultSet));
                }
                return Optional.empty();
            }
        }
    }

    @Override
    public List<Produto> listarTodos() throws SQLException {
        List<Produto> produtos = new ArrayList<>();

        try (Connection connection = ConexaoSQLite.abrir();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_SQL);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                produtos.add(mapear(resultSet));
            }
        }

        return produtos;
    }

    @Override
    public boolean atualizar(Produto produto) throws SQLException {
        validarProduto(produto);

        if (produto.getId() <= 0) {
            throw new IllegalArgumentException("O produto precisa de um id para ser atualizado.");
        }

        try (Connection connection = ConexaoSQLite.abrir();
             PreparedStatement statement = connection.prepareStatement(UPDATE_SQL)) {
            preencherDados(statement, produto);
            statement.setLong(4, produto.getId());
            return statement.executeUpdate() == 1;
        }
    }

    @Override
    public boolean excluir(long id) throws SQLException {
        try (Connection connection = ConexaoSQLite.abrir();
             PreparedStatement statement = connection.prepareStatement(DELETE_SQL)) {
            statement.setLong(1, id);
            return statement.executeUpdate() == 1;
        }
    }

    private static void preencherDados(PreparedStatement statement, Produto produto)
            throws SQLException {
        statement.setString(1, produto.getNome());
        statement.setDouble(2, produto.getPreco());
        statement.setInt(3, produto.getEstoque());
    }

    private static Produto mapear(ResultSet resultSet) throws SQLException {
        return new Produto(
                resultSet.getLong("id"),
                resultSet.getString("nome"),
                resultSet.getDouble("preco"),
                resultSet.getInt("estoque")
        );
    }

    private static void validarProduto(Produto produto) {
        if (produto == null) {
            throw new IllegalArgumentException("O produto não pode ser nulo.");
        }
        if (produto.getNome() == null || produto.getNome().isBlank()) {
            throw new IllegalArgumentException("O nome do produto é obrigatório.");
        }
        if (produto.getPreco() < 0) {
            throw new IllegalArgumentException("O preço não pode ser negativo.");
        }
        if (produto.getEstoque() < 0) {
            throw new IllegalArgumentException("O estoque não pode ser negativo.");
        }
    }
}
