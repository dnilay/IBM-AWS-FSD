package com.example.todorest;

import com.example.todorest.dao.TodoDao;
import com.example.todorest.model.Todo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
@Slf4j
public class TodoRestApplication implements CommandLineRunner {

    private TodoDao todoDao;

    @Autowired
    public TodoRestApplication(TodoDao todoDao) {
        this.todoDao = todoDao;
    }

    public static void main(String[] args) {
        log.info("starting app");
        SpringApplication.run(TodoRestApplication.class, args);
        log.info("app successfully started");
    }

    @Override
    public void run(String... args) throws Exception {
        todoDao.save(new Todo(UUID.randomUUID().toString(),"Demo desc1","01-04-21",false));
        todoDao.save(new Todo(UUID.randomUUID().toString(),"Demo desc2","02-04-21",true));
        todoDao.save(new Todo(UUID.randomUUID().toString(),"Demo desc3","03-04-21",false));



    }
}
