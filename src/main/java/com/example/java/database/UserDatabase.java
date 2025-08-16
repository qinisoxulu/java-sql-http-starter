package com.example.java.database;

import java.util.List;

public interface UserDatabase {
    User get(Integer id);
    List<User> all();
    User add(User user);
}