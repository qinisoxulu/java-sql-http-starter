package com.example.java.api;

import io.javalin.Javalin;

public class PostHello {
    private final Javalin server;

    public PostHello() {
        this.server = Javalin.create();
        this.server.post("/hello", context -> {String name = context.body();context.result("Hello, " + name + "!"); context.status(201);});
    }

    public Javalin start() {
        return this.server.start(5000);
    }
    
    public Javalin stop() {
        return this.server.stop();
    }
    
    public static void main(String[] args) {
        PostHello api = new PostHello();
        api.start();
    }
}