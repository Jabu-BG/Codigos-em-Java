package br.edu.dao.infra;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Cria a tabela necessária para o exemplo, caso ela ainda não exista.
 */
public final class DatabaseInitializer {
    private static final String CREATE_PRODUTO_TABLE = """
            CREATE TABLE IF NOT EXISTS produto (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                nome TEXT NOT NULL CHECK (trim(nome) <> ''),
                preco REAL NOT NULL CHECK (preco >= 0),
                estoque INTEGER NOT NULL CHECK (estoque >= 0)
            )
            """;

    private DatabaseInitializer() {
    }

    public static void inicializar() throws SQLException {
        try (Connection connection = ConexaoSQLite.abrir();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(CREATE_PRODUTO_TABLE);
        }
    }
}
