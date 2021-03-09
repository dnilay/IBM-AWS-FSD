package com.example.todorest.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HomeController {
    @GetMapping("/")
    public ResponseEntity<String> hello()
    {
        log.info("home rest controller called.");
        log.error("error occurred");
        return ResponseEntity.ok().body("hello world rest");

    }



}
