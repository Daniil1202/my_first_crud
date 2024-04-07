package my.example.my_first_crud.repository;

import my.example.my_first_crud.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {
    private final JdbcTemplate jdbsTemp;

    public UserRepository(JdbcTemplate jdbsTemp) {
        this.jdbsTemp = jdbsTemp;
    }

    public List<User> findAll() {
        String sql = "SELECT * FROM userTable";

        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setFirstName(r.getString("firstName"));
            rowObject.setLastName(r.getString("lastName"));
            return rowObject;

        };
        return jdbsTemp.query(sql, userRowMapper);
    }

    public User save(User user) {
        String sql = "INSERT INTO userTable(firstName,lastName) VALUES (?,?)";
        jdbsTemp.update(sql, user.getFirstName(), user.getLastName());
        return user;

    }

    public void deleteById(int id){
        String sql = "DELETE FROM userTable WHERE id = ?";
        jdbsTemp.update(sql,id);
    }

    public void updateById(int id, String firstName, String lastName) {
        String sql = "UPDATE userTable SET firstName = ?, lastName = ?" +
                " WHERE id = ?";
        jdbsTemp.update(sql,firstName,lastName,id);
    }
}

