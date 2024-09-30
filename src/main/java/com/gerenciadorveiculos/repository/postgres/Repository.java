package com.gerenciadorveiculos.repository.postgres;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Repository {

    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";
    private static Repository instance;
    private final Connection connection;

    private Repository() throws SQLException {
        connection = DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static Repository getInstance() throws SQLException {
        if (instance == null) {
            instance = new Repository();
        }
        return instance;
    }

    public PreparedStatement prepareStatement(String sql) throws SQLException {
        return connection.prepareStatement(sql);
    }

}
