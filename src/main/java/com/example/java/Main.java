package com.example.java;

import com.example.java.database.UserDO;
import net.lemnik.eodsql.QueryTool;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) throws Exception {
        String path = "./java.db";
        String url = "jdbc:sqlite:" + path;
        UserDO.UserDAI userDAO = QueryTool.getQuery(DriverManager.getConnection(url), UserDO.UserDAI.class);
        UserDO user = new UserDO("Alice");
        userDAO.create(user);
        UserDO foundUser = userDAO.find(1);
        System.out.println("Found: " + foundUser.name);
        user.name = "Bob";
        user.id = 1;
        userDAO.update(user);
        UserDO[] allUsers = userDAO.all();
        for (UserDO u : allUsers) {
            System.out.println("User: " + u.name);
        }
        userDAO.delete(1);
    }
}