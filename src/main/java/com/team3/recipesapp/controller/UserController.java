package com.team3.recipesapp.controller;

import com.team3.recipesapp.model.User;
import com.team3.recipesapp.security.ApplicationSecurityConfig;
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
    public void addUser(@RequestBody User user){
        User newUser = new User(user.getUsername(),user.getEmail(), ApplicationSecurityConfig.passwordEncoder().encode(user.getPassword()));
        userService.saveUser(newUser);
    }

    @GetMapping("/profile")
    public void profile(){

    }

    @PutMapping(path ="/{id}")
    public String replaceUser(@RequestBody User newUser, @PathVariable String id) {

        userService.replaceUser(newUser,id);
        return "home";
    }


    @DeleteMapping(path ="/{id}")
    public String deleteUser(@PathVariable String id) {
        userService.deleteById(id);

        return "home";
    }

}
