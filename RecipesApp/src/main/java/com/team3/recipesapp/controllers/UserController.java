package com.team3.recipesapp.controllers;



import com.team3.recipesapp.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;

@Controller
public class UserController {
    @GetMapping("/user")
    String getUser(Model model){
        model.addAttribute("something", "controller is making you see this");
        model.addAttribute("people", Arrays.asList(
                new Person("John", 20, 3 ),
                new Person("Mary", 20, 15),
                new Person("Peter", 20, 60)
                ));
        return "user";
    }

}
