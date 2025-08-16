package com.example.java;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;
import org.junit.jupiter.api.*;

import com.example.java.database.User;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserApiTests {
    private static UserServer server;

    @BeforeAll
    public static void startServer() {
        server = new UserServer();
        server.start(5000);
    }

    @AfterAll
    public static void stopServer() {
        server.stop();
    }

    @Test
    @DisplayName("GET /user/{id}")
    public void getOneUser() throws UnirestException {
        HttpResponse<JsonNode> response = Unirest.get("http://localhost:5000/user/1").asJson();
        assertEquals(200, response.getStatus());
        assertEquals("application/json", response.getHeaders().getFirst("Content-Type"));

        JSONObject jsonObject = response.getBody().getObject();
        assertEquals("Unknown", jsonObject.get("name"));
    }

    @Test
    @DisplayName("GET /users")
    void getAllQuotes() throws UnirestException {
        HttpResponse<JsonNode> response = Unirest.get("http://localhost:5000/users").asJson();
        assertEquals(200, response.getStatus());
        assertEquals("application/json", response.getHeaders().getFirst("Content-Type"));
        JSONArray jsonArray = response.getBody().getArray();
        assertTrue(jsonArray.length() > 1);
    }

    @Test
    @DisplayName("POST /users")
    void create() throws UnirestException {
        HttpResponse<JsonNode> response = Unirest.post("http://localhost:5000/users")
                .header("Content-Type", "application/json")
                .body(User.create("The Cat"))
                .asJson();
        assertEquals(201, response.getStatus());
        assertEquals("/user/4", response.getHeaders().getFirst("Location"));
        response = Unirest.get("http://localhost:5000/user/4").asJson();
        assertEquals(200, response.getStatus());
    }
}