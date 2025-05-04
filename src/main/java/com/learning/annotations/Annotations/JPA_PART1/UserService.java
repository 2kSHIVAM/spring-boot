package com.learning.annotations.Annotations.JPA_PART1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public String createUserTable(){
        userRepository.createUserTable();
        return "User table created !!";
    }

    public String addUser(String userName, int age) {
        userRepository.addUser(userName, age);
        return "User added successfully";
    }

    public List<User> getAllUsers(){
        return userRepository.getAllUsers();
    }

    public List<String> getAllsUserNames(){
        return userRepository.getAllUserNames();
    }

    public int getUsersCounts(){
        return userRepository.getUsersCounts();
    }
}
