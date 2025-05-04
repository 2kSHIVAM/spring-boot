package com.learning.annotations.Annotations.JPA_PART1;

public class User {
    private int userId;
    private String userName;
    private int age;

    public void setUserId(int userId){
        this.userId=userId;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public void setAge(int age) {
        this.age=age;
    }

    public int getUserId(){
        return this.userId;
    }

    public String getUserName(){
        return this.userName;
    }

    public int getAge(){
        return this.age;
    }
}
