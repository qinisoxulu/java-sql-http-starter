package com.example.java.database;

public class User {
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static User create(String name) {
        User user = new User();
        user.setName(name);
        return user;
    }
}
