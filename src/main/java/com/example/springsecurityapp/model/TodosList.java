package com.example.springsecurityapp.model;

import java.util.List;

public class TodosList {
    private List<Todo> todos;

    public TodosList(List<Todo> todos) {
        this.todos = todos;
    }

    public List<Todo> getTodos() {
        return todos;
    }

    public void setTodos(List<Todo> todos) {
        this.todos = todos;
    }
}
