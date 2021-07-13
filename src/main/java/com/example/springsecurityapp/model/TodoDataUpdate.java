package com.example.springsecurityapp.model;

public class TodoDataUpdate extends TodoId{
    private String text;
    private boolean completed;

    public TodoDataUpdate() {
    }

    public TodoDataUpdate(Long id, String text, boolean completed) {
        super(id);
        this.text = text;
        this.completed = completed;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
