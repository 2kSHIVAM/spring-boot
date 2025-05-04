package com.learning.annotations.Annotations.JPA_PART1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection1 {
    public Connection getConnection() {
        try {
            Class.forName("org.h2.Driver");
            return DriverManager.getConnection("jdbc:h2:mem:userDB", "sa", "");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Shit!! we got some error");
        }
        return null;
    }
}
