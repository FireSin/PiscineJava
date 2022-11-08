package edu.school21.chat.app;

import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;
import edu.school21.chat.repositories.MessagesRepository;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;

import javax.sql.DataSource;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Program {
    public static void main(String[] args){
       DataSource ds = getDataSource();
       DeleteTables(ds);
       CreateTables(ds);
       InsertData(ds);
       MessagesRepository messagesRepository = new MessagesRepositoryJdbcImpl(ds);
       User creator = new User(1L, "user1", "123", new ArrayList(), new ArrayList());
       User author = creator;
       Chatroom room = new Chatroom(1L, "room1", creator, new ArrayList());
       Message message = new Message(null, author, room, "Hello!", LocalDateTime.now());
       messagesRepository.save(message);
       System.out.println(message.get_id());
//       DeleteTables(ds);
    }

    private static void CreateTables(DataSource ds){
        Connection connection = null;
        List<String> fileContent = null;
        try {
            connection = ds.getConnection();
            fileContent = Files.readAllLines(Paths.get("src/main/resources/schema.sql"));
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
            fileContent = Files.readAllLines(Paths.get("src/main/resources/data.sql"));
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

    public static void DeleteTables(DataSource ds){
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
