package com.example.java.api;

import io.javalin.Javalin;

public class GetHello {
    private final Javalin server;

    public GetHello() {
        this.server = Javalin.create();
        this.server.get("hello", context -> context.result("Hello world!"));
    }
    
    public Javalin start() {return this.server.start(5000);}

    public Javalin stop() {return this.server.stop();}
}