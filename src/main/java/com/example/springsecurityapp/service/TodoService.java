package com.example.springsecurityapp.service;

import com.example.springsecurityapp.model.Todo;
import com.example.springsecurityapp.model.User;
import com.example.springsecurityapp.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> getTodosByUser(User user){
        return todoRepository.findAllByUser(user);
    }

    public void deleteById(User user, long id){
        Optional<Todo> todo = todoRepository.findById(id);
        if (!todo.isPresent()){
            throw new IllegalStateException("Todo not found.");
        }
        if (!todo.get().getUser().equals(user))
            throw new IllegalStateException("Access to this todo is denied");
        todoRepository.deleteById(id);
    }

    @Transactional
    public void update(User user, long id, String text, boolean completed){
        Optional<Todo> todo = todoRepository.findById(id);
        if (!todo.isPresent()){
            throw new IllegalStateException("Todo not found.");
        }

        if(!todo.get().getUser().equals(user)){
            throw new IllegalStateException("Access to this todo is denied");
        }
        if (text != null && text.length() > 0 && !Objects.equals(text, todo.get().getText())){
            todo.get().setText(text);
        }
        if (completed != todo.get().isCompleted()){
            todo.get().setCompleted(completed);
        }
    }

    public void add(User user, String text){
        todoRepository.save(new Todo(LocalDateTime.now().toString(), text, false, user));
    }
}

