package com.example.java;

import io.javalin.Javalin;
// import static io.javalin.apibuilder.ApiBuilder.*;

import com.example.java.database.UserApiHandler;


public class UserServer {
    private final Javalin server;
    
    public UserServer() {
        server = Javalin.create(config -> {
            config.defaultContentType = "application/json";
        });
    
        this.server.get("/users", context -> UserApiHandler.getAll(context));
        this.server.get("/user/{id}", context -> UserApiHandler.getOne(context));
        this.server.post("/users", context -> UserApiHandler.create(context));
    }
    
    public static void main(String[] args) {
        UserServer server = new UserServer();
        server.start(5000);
    }
    
    public void start(int port) {
        this.server.start(port);
    }
    
    public void stop() {
        this.server.stop();
    }
}