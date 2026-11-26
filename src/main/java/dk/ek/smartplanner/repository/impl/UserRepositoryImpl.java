package dk.ek.smartplanner.repository.impl;

import dk.ek.smartplanner.model.User;
import dk.ek.smartplanner.repository.UserRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final JdbcTemplate jdbcTemplate;

    public UserRepositoryImpl (JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}

    public void create(User user){
        String sql = "INSERT INTO users (name, email, passwordHash, role) VALUES (?, ?, ?,?)";

        jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getPasswordHash(), user.getRole());
    }

    public User findByEmail(String email) {

        String sql = "SELECT * FROM users WHERE email = ?";

        List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class), email);

        if (users.isEmpty()) {
            return null;
        }

        return users.get(0);
    }

    public boolean emailExists(String email) {
        return findByEmail(email) != null;
    }
}
