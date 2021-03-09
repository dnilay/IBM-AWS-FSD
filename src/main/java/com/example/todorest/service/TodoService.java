package com.example.todorest.service;

import com.example.todorest.model.Todo;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TodoService {
    public ResponseEntity<List<Todo>> getAllTodo();

}
