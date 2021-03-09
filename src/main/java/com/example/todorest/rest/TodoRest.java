package com.example.todorest.rest;

import com.example.todorest.model.Todo;
import com.example.todorest.service.TodoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class TodoRest {

private TodoService todoService;

@Autowired
    public TodoRest(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/todos")
    public ResponseEntity<List<Todo>> getAllTodo()
    {
        log.info("entered into todo get controller.");
        return todoService.getAllTodo();
    }

}
