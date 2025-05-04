package com.learning.annotations.Annotations.JPA_PART1;

import org.springframework.stereotype.Component;

import java.sql.*;

@Component
public class UserDAO {
    public void createTable(){
        try{
            Connection connection = new DataBaseConnection1().getConnection();
            String sqlCreateTable = "CREATE TABLE users (user_id INT AUTO_INCREMENT PRIMARY KEY, user_name VARCHAR(100), age INT)";
            Statement statement = connection.createStatement();
            statement.executeUpdate(sqlCreateTable);
        }catch (SQLException ex){
            System.out.println("Shit!! we got sql exception aaaa...");
            System.out.println(ex.getMessage());
        }
    }

    public void createUser(String userName, int age) {
        try{
            Connection connection = new DataBaseConnection1().getConnection();
            String sqlCreateUser = "INSERT INTO users (user_name, age) VALUES(?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlCreateUser);
            preparedStatement.setString(1, userName);
            preparedStatement.setInt(2, age);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Shit!! we got sql exception aaaa...");
            System.out.println(ex.getMessage());
        }
    }

    public void readUsers(){
        try{
            Connection connection = new DataBaseConnection1().getConnection();
            String sqlSelectAllUsers = "Select * from users";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlSelectAllUsers);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("********************************");
            while(resultSet.next()){
                String userDetails = resultSet.getInt("user_id")+
                        ":"+resultSet.getString("user_name")+
                        ":"+resultSet.getInt("age");
                System.out.println(userDetails);
            }
            System.out.println("********************************");
        } catch (SQLException ex) {
            System.out.println("Shit!! we got sql exception aaaa...");
        }
    }
}
