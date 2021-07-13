package com.example.springsecurityapp.model;

public class LoginResponse {
    private Long userId;
    private String name;
    private String token;

    public LoginResponse(Long id, String name, String token) {
        this.userId = id;
        this.name = name;
        this.token = token;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
