package com.team3.recipesapp.controller;

import com.team3.recipesapp.model.User;
import com.team3.recipesapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@RestController
@RequiredArgsConstructor
//@RequestMapping("${application.context}/${application.version}")
public class UserController {

    @Autowired
    private final UserService userService;

    @GetMapping(value = "/home")
    public String home(){
        return "Hello from our website. This is a functionality test";
    }

    @GetMapping(value = "/users")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @PostMapping("/user")
    public ModelAndView addUser(@RequestBody User user){
        ModelAndView modelAndView = new ModelAndView("redirect:index");
        userService.saveUser(user);
        return modelAndView;
    }



}
