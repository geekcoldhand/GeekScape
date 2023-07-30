package com.example.GeekScape;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UserController {

    private  UserRepo userRepo;

  @Autowired
    public UserController(UserRepo userRepo){
        this.userRepo = userRepo;
    }
    @GetMapping("/user")
    public String getAllUsers(Model model){

        return "all users"; //returns the mainFeed view fragment

}
    @PostMapping("/user/{username}")
    public String createNewUser(@PathVariable("username") String username, Model model) {

        model.addAttribute("name", "horatiuos");
        return "create users";
    }

    }
