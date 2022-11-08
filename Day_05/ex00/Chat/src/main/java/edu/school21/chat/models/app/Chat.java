package edu.school21.chat.models.app;

import java.sql.*;

public class Chat {
    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection test = DriverManager.getConnection("jdbc:postgresql://localhost:5432/mychat", "postgres", "");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
