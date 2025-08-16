package com.example.java;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.java.api.GetHello;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetHelloTest {
    @Test
    @DisplayName("GET /hello")
    public void shouldGetHelloWorld() {
        GetHello api = new GetHello();
        api.start();
        HttpResponse<String> response = Unirest.get("http://localhost:5000/hello").asString();
        assertEquals(200, response.getStatus());
        assertEquals("Hello world!", response.getBody());
        api.stop();
    }
}