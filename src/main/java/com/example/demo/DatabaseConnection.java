package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
    Connection connection;
    Statement statement;
    public DatabaseConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/hoadb";
            connection = DriverManager.getConnection(url,"root","12345678");
            statement = connection.createStatement();
            connection.close();
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }
    public void insertToAsset(String values) {
        try {
            String query = "INSERT INTO " + "assets" + " VALUES (" + values + ")";
            statement.executeUpdate(query);
        } catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage());
        }
    }

    public void deleteFromTable(String tableName, String condition) {
        try {
            String query = "DELETE FROM " + tableName + " WHERE " + condition;
            statement.executeUpdate(query);
        } catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage());
        }
    }

    public void disposeRowFromTable(String tableName, String condition) {
        try {
            String query = "DELETE FROM " + tableName + " WHERE " + condition;
            statement.executeUpdate(query);
        } catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        DatabaseConnection databaseConnection =new DatabaseConnection();
    }
}