package com.learning.annotations.Annotations.Hateoas;

import org.springframework.hateoas.Link;
import org.springframework.stereotype.Component;

import java.util.List;

public class UserResponse extends HateoasLinks{
    String name;
    String gender;
    int id;

    public void setUserDetails(User user) {
        this.name=user.name;
        this.gender=user.gender;
        this.id=user.id;
    }

    public String getName(){
        return name;
    }

    public String getGender(){
        return this.gender;
    }

    public int getId(){
        return this.id;
    }

    public List<Link> getLinks(){
        return fetchLinks();
    }

}
