package com.example.demo.service;

import com.example.demo.model.Todo;
import com.example.demo.repo.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
@EnableTransactionManagement
public class TodoService {
    private TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    private static List<Todo> todos = new ArrayList<Todo>();
    private static int todoCount = 3;

    static {
        todos.add(new Todo(1, "dummy", "Learn Spring MVC", new Date(),
                false));
        todos.add(new Todo(2, "dummy", "Learn Struts", new Date(), false));
        todos.add(new Todo(3, "dummy", "Learn Hibernate", new Date(),
                false));
    }

    public List<Todo> retrieveTodos(String user) {
        List<Todo> filteredTodos = new ArrayList<Todo>();
        /*for (Todo todo : todos) {
            if (todo.getUser().equals(user)) {
                filteredTodos.add(todo);
            }
        }*/

        filteredTodos=todoRepository.findAll();

        return filteredTodos;
    }

    @Transactional
    public void addTodo(String name, String desc, Date targetDate,
                        boolean isDone) {
        todoRepository.save(new Todo(name,desc,targetDate,isDone));
       // todos.add(new Todo(++todoCount, name, desc, targetDate, isDone));
    }
}