package com.example.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect {
    static String path = "./java.db";
    static String url = "jdbc:sqlite:" + path;
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(url)) {
            try (Statement stmt = connection.createStatement()) {
                stmt.execute("CREATE TABLE IF NOT EXISTS users (id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR(255))");
            }
        } catch (SQLException e) {
            System.err.println("Error" + e.getMessage());
        }
    }
    
    //This is a temporal solution & must be reimplemented before production
    public static void delete() {
        try (Connection connection = DriverManager.getConnection(url); Statement stmt = connection.createStatement()) {
            stmt.execute("DROP TABLE IF EXISTS users");
        } catch (SQLException e) {
            System.err.println("Error" + e.getMessage());
        }
    }
}