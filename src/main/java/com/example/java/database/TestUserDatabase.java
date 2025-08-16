package com.example.java.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestUserDatabase implements UserDatabase {
    private Map<Integer, User> users;
    
    public TestUserDatabase() {
        users = new HashMap<>();
        this.add(User.create("Unknown"));
        this.add(User.create("Robert A. Heinlein"));
        this.add(User.create("Robert Byrne"));
    }
    
    @Override
    public User get(Integer id) {
        return users.get(id);
    }
    
    @Override
    public List<User> all() {
        return new ArrayList<>(users.values());
    }
    
    @Override
    public User add(User User) {
        Integer index = users.size() + 1;
        User.setId(index);
        users.put(index, User);
        return User;
    }
}