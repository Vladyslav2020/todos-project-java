package com.example.springsecurityapp.controller;

import com.example.springsecurityapp.model.*;
import com.example.springsecurityapp.service.TodoService;
import com.example.springsecurityapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodosController {
    private final TodoService todoService;
    private final UserService userService;

    private User getAuthenticatedUser(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return userService.findByEmail(auth.getName());
    }

    @Autowired
    public TodosController(TodoService todoService, UserService userService) {
        this.todoService = todoService;
        this.userService = userService;
    }

    @GetMapping
    public TodosList getAll(){
        return new TodosList(todoService.getTodosByUser(getAuthenticatedUser()));
    }

    @DeleteMapping("/delete")
    public MessageResponse delete(@RequestBody TodoId id){
        todoService.deleteById(getAuthenticatedUser(), id.getId());
        return new MessageResponse("Todos successfully deleted");
    }

    @PutMapping("/update")
    public MessageResponse update(@RequestBody TodoDataUpdate todoDataUpdate){
        todoService.update(getAuthenticatedUser(), todoDataUpdate.getId(), todoDataUpdate.getText(), todoDataUpdate.isCompleted());
        return new MessageResponse("Todos successfully updated");
    }

    @PostMapping("/add")
    public MessageResponse add(@RequestBody TodoText todoText){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByEmail(auth.getName());
        todoService.add(user, todoText.getText());
        return new MessageResponse("Todo saved");
    }
}
