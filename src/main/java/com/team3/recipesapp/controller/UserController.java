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
import java.util.Objects;

@Controller
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private final UserService userService;

    @GetMapping("/registration")
    public void home(){
        //return "Hello from our website. This is a functionality test";
    }

    @GetMapping("/users")
    public String getUsers(){
        return "users";
    }

    @PostMapping("/user")
    public User addUser(@RequestBody User user){
        User newUser = new User(user.getUsername(),user.getEmail(),user.getPassword());
        return userService.saveUser(newUser);
    }

    @PutMapping("/users/{id}")
    public User replaceUser(@RequestBody User newUser, @PathVariable String id) {

        return userService.replaceUser(newUser,id);
    }

    @DeleteMapping("/employees/{id}")
    void deleteUser(@PathVariable String id) {
        userService.deleteById(id);
    }





}
