package com.example.GeekScape;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {



    @GetMapping
    public String getAllUsers(Model model){
        model.addAttribute("name", "horatiuos");
        return "mainFeed";
    }

}
