package com.example.java;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.java.api.PostHello;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PostHelloTest {
    @Test
    @DisplayName("POST /hello")
    public void shouldGreet() {
        PostHello api = new PostHello();
        api.start();
        HttpResponse<String> response = Unirest.post("http://localhost:5000/hello").body("World").asString();
        assertEquals(201, response.getStatus());
        assertEquals("Hello, World!", response.getBody());
        api.stop();
    }
}

