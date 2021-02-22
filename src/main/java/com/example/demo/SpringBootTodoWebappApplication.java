package com.example.demo;

import com.example.demo.model.Todo;
import com.example.demo.repo.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication

public class SpringBootTodoWebappApplication implements CommandLineRunner {

    private TodoRepository todoRepository;

    @Autowired
    public SpringBootTodoWebappApplication(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootTodoWebappApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        todoRepository.save(new Todo("dummy","spring",new Date(),false));
        todoRepository.save(new Todo("dummy","Struts",new Date(),false));
        todoRepository.save(new Todo("dummy","Node",new Date(),true));
        todoRepository.save(new Todo("dummy","React",new Date(),false));
        todoRepository.save(new Todo("dummy","Flask",new Date(),true));
    }
}
