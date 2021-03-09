package com.example.todorest.service;

import com.example.todorest.dao.TodoDao;
import com.example.todorest.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService{
    private TodoDao todoDao;

    @Autowired
    public TodoServiceImpl(TodoDao todoDao) {
        this.todoDao = todoDao;
    }


    @Override
    public ResponseEntity<List<Todo>> getAllTodo() {
        return ResponseEntity.ok().body(todoDao.findAll());
    }
}
