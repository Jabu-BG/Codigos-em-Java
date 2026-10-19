package br.edu.dao.infra;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Fábrica simples de conexões para a demonstração em sala.
 */
public final class ConexaoSQLite {
    private static final String URL = "jdbc:sqlite:dados/loja.db";

    private ConexaoSQLite() {
    }

    public static Connection abrir() throws SQLException {
        criarDiretorioDeDados();
        Connection connection = DriverManager.getConnection(URL);

        // No SQLite, a integridade referencial é habilitada por conexão.
        try (Statement statement = connection.createStatement()) {
            statement.execute("PRAGMA foreign_keys = ON");
        }

        return connection;
    }

    private static void criarDiretorioDeDados() throws SQLException {
        try {
            Files.createDirectories(Path.of("dados"));
        } catch (IOException e) {
            throw new SQLException("Não foi possível criar o diretório de dados.", e);
        }
    }
}
