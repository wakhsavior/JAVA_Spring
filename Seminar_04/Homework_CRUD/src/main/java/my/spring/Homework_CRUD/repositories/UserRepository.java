package my.spring.Homework_CRUD.repositories;

import lombok.RequiredArgsConstructor;
import my.spring.Homework_CRUD.model.User;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepository {
    private final JdbcTemplate jdbc;

    public List<User> findAll() {
        String sql = "SELECT * FROM userTable";

        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setFirstName(r.getString("firstName"));
            rowObject.setLastName(r.getString("lastName"));
            return rowObject;
        };

        return jdbc.query(sql, userRowMapper);
    }

    public User save(User user) {
        String sql = "INSERT INTO userTable (firstName,lastName) VALUES ( ?, ?)";
        jdbc.update(sql, user.getFirstName(), user.getLastName());
        return user;
    }

    public void deleteById(int id) {
        String sql = "DELETE FROM userTable WHERE id=?";
        jdbc.update(sql, id);
    }
    public void updateById(User user) {
        String sql = "UPDATE userTable SET firstName = ?, lastName = ? WHERE id=?";
        jdbc.update(sql, user.getFirstName(),user.getLastName(),user.getId());
    }
    public Optional<User> getUserById(int id){
        String sql = "SELECT * FROM userTable WHERE id=?";
        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setFirstName(r.getString("firstName"));
            rowObject.setLastName(r.getString("lastName"));
            return rowObject;
        };
        System.out.println(jdbc.query(sql, userRowMapper,id).stream().findAny().get());
        return jdbc.query(sql, userRowMapper,id).stream().findAny();
    }
}
