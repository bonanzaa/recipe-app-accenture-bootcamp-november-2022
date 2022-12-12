package com.team3.recipesapp;

import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class TodoController {
    private final TodoRepository todoRepository;

    public TodoController(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }

//    @PostConstruct
//    public void init(){
//        todoRepository.saveAll(Arrays.asList(
//                new Todo("First item",true),
//                new Todo("Second item",true),
//                new Todo("Third item",false)
//        ));
//    }

    @RequestMapping("/test")
    public String getTodos(){
        //return todoRepository.findAll();
        return "THIS IS A TEST";
    }
}
