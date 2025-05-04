package com.learning.annotations.Annotations.JPA_PART1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void createUserTable(){
        String sqlCreateTable = "CREATE TABLE users (user_id INT AUTO_INCREMENT PRIMARY KEY, user_name VARCHAR(100), age INT)";
        jdbcTemplate.execute(sqlCreateTable);
    }

    public void addUser(String userName, int age) {
        String sqlAddUserQuery = "INSERT INTO users (user_name, age) VALUES (?, ?)";
        jdbcTemplate.update(sqlAddUserQuery, userName, age);
    }

    public List<User> getAllUsers(){
        String sqlGetAllUsers = "SELECT * FROM users";
        return jdbcTemplate.query(sqlGetAllUsers,(resultSet, rowNum) -> {
            User user = new User();
            user.setUserId(resultSet.getInt("user_id"));
            user.setUserName(resultSet.getString("user_name"));
            user.setAge(resultSet.getInt("age"));
            return user;
        });
    }

    public List<String> getAllUserNames(){
        String sqlGetAllUserNames="SELECT user_name from users";
        return jdbcTemplate.queryForList(sqlGetAllUserNames, String.class);
    }

    public int getUsersCounts(){
        String sqlGetUsersCounts = "SELECT COUNT(*) from users";
        return jdbcTemplate.queryForObject(sqlGetUsersCounts, Integer.class);
    }
}
