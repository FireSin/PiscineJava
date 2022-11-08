package edu.school21.chat.app;

import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.Message;
import edu.school21.chat.repositories.MessagesRepository;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;

import javax.sql.DataSource;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Program {
    public static void main(String[] args){
       DataSource ds = getDataSource();
//       CreateTables(ds);
//       InsertData(ds);
       MessagesRepository messagesRepository = new MessagesRepositoryJdbcImpl(ds);
       Scanner sc = new Scanner(System.in);
       System.out.print("Enter message ID:\n-> ");
       if (sc.hasNextLong()) {
           Optional<Message> optionalMessage = messagesRepository.findById(sc.nextLong());
           if (optionalMessage.isPresent()) {
               System.out.println(optionalMessage.get());
           } else {
               System.out.println("Error: no message found with such id");
           }
       }
       sc.close();
//       DeleteTables(ds);
    }

    private static void CreateTables(DataSource ds){
        Connection connection = null;
        List<String> fileContent = null;
        try {
            connection = ds.getConnection();
            fileContent = Files.readAllLines(Paths.get("Chat/src/main/resources/schema.sql"));
            String sql = "";
            for(String line : fileContent) {
                sql = sql + line;
            }
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void InsertData(DataSource ds){
        Connection connection = null;
        List<String> fileContent = null;
        try {
            connection = ds.getConnection();
            fileContent = Files.readAllLines(Paths.get("Chat/src/main/resources/data.sql"));
            String sql = "";
            for(String line : fileContent) {
                sql = sql + line;
            }
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void DeleteTables(DataSource ds){
        Connection connection = null;
        try {
            connection = ds.getConnection();
            PreparedStatement ps = connection.prepareStatement("DROP TABLE users CASCADE; DROP TABLE chatrooms CASCADE; DROP TABLE messages");
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static DataSource getDataSource() {
        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl("jdbc:postgresql://localhost:5432/mychat");
        ds.setUsername("postgres");
        ds.setPassword("");
        return ds;
    }
}
