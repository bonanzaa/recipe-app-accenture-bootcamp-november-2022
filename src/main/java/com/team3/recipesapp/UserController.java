package com.team3.recipesapp;

import com.azure.core.annotation.Get;
import com.azure.core.annotation.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
//@RestController
//@RequiredArgsConstructor
public class UserController {
    private UserService userService;

    //@Autowired
    private UserRepository repository;

//    @GetMapping("/users")
//    public ModelAndView getUsers(){
//        ModelAndView modelAndView = new ModelAndView("getUser");
//        modelAndView.addObject("get_user", new User());
//        return modelAndView;
//        //return repository.findAll();
//    }
//
//    @PostMapping("/user")
//    public ModelAndView addUser(@RequestBody User user){
//        ModelAndView modelAndView = new ModelAndView("redirect:index");
//        userService.saveUser(user);
//        return modelAndView;
//    }


}
