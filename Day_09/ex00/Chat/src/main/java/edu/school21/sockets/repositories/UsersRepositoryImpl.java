package edu.school21.sockets.repositories;

import edu.school21.sockets.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

public class UsersRepositoryImpl implements UsersRepository{
    private final JdbcTemplate template;

    private final RowMapper<User> ROW_MAPPER = (ResultSet resultSet, int rowNum) ->
            new User(resultSet.getLong(1), resultSet.getString(2), resultSet.getString(3));

    @Autowired
    public UsersRepositoryImpl(DriverManagerDataSource ds) {
        this.template = new JdbcTemplate(ds);
    }

    @Override
    public User findById(Long id) {
        User user = null;
        try {
            user = this.template.queryForObject(String
                    .format("SELECT * FROM models.user WHERE id = %d", id), ROW_MAPPER);
        } catch (DataAccessException e) {
            System.err.println("Couldn't find user with id = " + id);
        }
        return user;
    }

    @Override
    public List<User> findAll() {
        return this.template.query("SELECT * FROM users", ROW_MAPPER);
    }

    @Override
    public void save(User entity) {
        this.template.update("INSERT INTO users (username, password) VALUES (" +entity.getUsername() +" ,'" + entity.getPassword()+ "')");
    }

    @Override
    public void update(User entity) {
        this.template.update("UPDATE users SET username = '"+ entity.getUsername() + "', password = '" + entity.getPassword() + "' WHERE id = " + entity.getIdentifier());
    }

    @Override
    public void delete(Long id) {
        this.template.update("DELETE FROM users WHERE id =" + id);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        Optional<User> optionalUser = Optional.empty();
        try {
            optionalUser = Optional.ofNullable(this.template.queryForObject(String
                    .format("SELECT * FROM models.user WHERE email = '%s'", username), ROW_MAPPER));
        } catch (DataAccessException e) {
            System.err.println("Couldn't find models.user with email = " + username);
        }
        return optionalUser;
    }
}
