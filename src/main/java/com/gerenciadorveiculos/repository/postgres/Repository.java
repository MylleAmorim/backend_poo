package com.gerenciadorveiculos.repository.postgres;

import java.sql.*;

public class Repository {

    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";
    private Statement statement;
    private Connection connection;

    private Repository() throws SQLException {
        connection = DriverManager.getConnection(URL, USER, PASSWORD);
        statement = connection.createStatement();
    }

    public static Repository getInstance() throws SQLException {
        return new Repository();
    }

    private Statement getStatement() {
        return statement;
    }

    public PreparedStatement prepareStatement(String sql) throws SQLException {
        return connection.prepareStatement(sql);
    }

    public ResultSet executeQuery(String query) throws SQLException {
        return getStatement().executeQuery(query);
    }

    public int executeUpdate(String query) throws SQLException {
        return getStatement().executeUpdate(query);
    }

    public void close() throws SQLException {
        getStatement().close();
    }

}
