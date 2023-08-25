package com.ict.capstoneproject.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectDB {
    public static Connection getConnection() {
        String jdbcUrl = "jdbc:postgresql://localhost:5432/postgres";
        String username = "postgres";
        String password = "14092003";
        Connection connection = null;

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(jdbcUrl, username, password);

            if (connection != null) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to connect to the database!");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }
    public static void main(String[] args) {
        Connection connection = getConnection();

        if (connection != null) {
            try {
                String sql = "SELECT * FROM ecobike";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    System.out.println(resultSet.getString("dock_name"));
                    // Retrieve data from the resultSet
                    // You can use resultSet.getXXX() methods, where XXX is the data type
                    // For example: String name = resultSet.getString("column_name");
                    // Process the retrieved data here
                }
                resultSet.close();
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
