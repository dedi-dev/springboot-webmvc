package com.belajar.webmvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {
    
    private List<String> todos = new ArrayList<>();

    @PostMapping(path = "/todos")
    public List<String> addTodo(@RequestParam(name = "todo") String todo) {
        todos.add(todo);
        return todos;
    }

    @GetMapping(path = "/todos")
    public List<String> getTodo() {
        return todos;
    }
}
