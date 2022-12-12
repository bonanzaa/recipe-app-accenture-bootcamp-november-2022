package com.team3.recipesapp;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("${application.context}/${application.version}")
public class UserController {
    private final UserService userService;

    @GetMapping(value = "/home")
    public String home(){
        return "Hello from our website. This is a functionality test";
    }

    @GetMapping(value = "/users")
    public List<User> getUsers(){
        return userService.getUsers();
    }



}
