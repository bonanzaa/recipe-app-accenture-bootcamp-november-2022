package com.team3.recipesapp.controller;

import com.team3.recipesapp.model.User;
import com.team3.recipesapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private final UserService userService;

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
