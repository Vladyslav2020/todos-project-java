package com.example.springsecurityapp.model;

public class TodoText {
    private String text;

    public TodoText() {
    }

    public TodoText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
