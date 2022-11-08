package edu.school21.chat.repositories;

import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Optional;

public class MessagesRepositoryJdbcImpl implements MessagesRepository{

    private DataSource _ds;

    public MessagesRepositoryJdbcImpl(DataSource ds){
        _ds = ds;
    }

    @Override
    public Optional<Message> findById(Long id) {
        String sql = "select messages.id, author_id, users.login, users.password, chatroom_id, chatrooms.name, chatrooms.owner_id, text, date " +
                "from messages inner join users on users.id=messages.author_id inner " +
                "join chatrooms on chatrooms.id=messages.chatroom_id where messages.id=" + id;
        Connection connection = null;
        Statement statement = null;
        Optional<Message> optionalMessage = null;
        try {
            connection = _ds.getConnection();
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            result.next();
            optionalMessage = Optional.of(new Message(result.getLong("id"),
                    new User(result.getLong("author_id"), result.getString("login"), result.getString("password"), null, null),
                    new Chatroom(result.getLong("chatroom_id"), result.getString("name"), null, null),
                    result.getString("text"),
                    result.getTimestamp("date")));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return optionalMessage;
    }
}
