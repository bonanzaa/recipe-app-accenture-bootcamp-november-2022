package com.team3.recipesapp.controller;

import com.team3.recipesapp.model.User;
import com.team3.recipesapp.repository.UserRepository;
import com.team3.recipesapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@RestController
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private final UserService userService;

    @GetMapping(value = "/")
    public String home(){
        return "Hello from our website. This is a functionality test";
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @PostMapping("/user")
    public User addUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @PutMapping("/users/{id}")
    public User replaceEmployee(@RequestBody User newUser, @PathVariable String id) {

        return userService.replaceUser(newUser,id);
    }

    @DeleteMapping("/employees/{id}")
    void deleteUser(@PathVariable String id) {
        userService.deleteById(id);
    }





}
