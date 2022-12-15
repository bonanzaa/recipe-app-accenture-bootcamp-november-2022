package com.team3.recipesapp.controller;

import com.team3.recipesapp.model.User;
import com.team3.recipesapp.repository.UserRepository;
import com.team3.recipesapp.security.ApplicationSecurityConfig;
import com.team3.recipesapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    @GetMapping("/users")
    public String getUsers(){
        return "users";
    }

    @PostMapping("/user")
    public User addUser(@RequestBody User user){
        User newUser = new User(user.getUsername(),user.getEmail(), ApplicationSecurityConfig.passwordEncoder().encode(user.getPassword()));
        return userService.saveUser(newUser);
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
