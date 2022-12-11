package com.team3.recipesapp;

import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class UserController {

    @GetMapping("/home")
    public String home(){
        return "Hello from our website. This is a functionality test";
    }


}
