package com.learning.annotations.Annotations.Hateoas;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public UserResponse getUser(){
        User user = new User("Shivam", "male", 1); // temporary creating the user
        UserResponse userResponse=new UserResponse();
        userResponse.setUserDetails(user);
        return userResponse;
    }
}
