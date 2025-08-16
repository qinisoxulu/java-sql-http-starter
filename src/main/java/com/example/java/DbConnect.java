package com.example.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnect {
    public static void main(String[] args) {
        String path = "./java.db";
        String url = "jdbc:sqlite:" + path;
        try (Connection connection = DriverManager.getConnection(url)) {
            try (Statement stmt = connection.createStatement()) {
                stmt.execute("CREATE TABLE IF NOT EXISTS users (id INTEGER PRIMARY KEY AUTO INCREMENT, name VARCHAR(255))");
            }
        } catch (SQLException e) {
            System.err.println("Error" + e.getMessage());
        }
    }
}