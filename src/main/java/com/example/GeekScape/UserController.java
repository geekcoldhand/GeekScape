package com.example.GeekScape;

import org.h2.engine.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@Controller
public class UserController {

    private final UserRepo userRepo;

    @Autowired
    public UserController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping("/user")
    public String getAllUsers(Model model) {
        try {
            List<UserType> allUsers = userRepo.findAll();
//            List<UserType> allUsers = List.of(new UserType("horatious", "helloGang"),
//                    new UserType("ray", "smallWorld"),
//                    new UserType("charles", "helloGang"));

            model.addAttribute("users", allUsers);
            return "layout"; //returns the mainFeed view fragment

        } catch (Exception e) {
            model.addAttribute("exception", e.getMessage());

        }
        return "errorPage";
    }

    @PostMapping("/user")
    public String createNewUser(@RequestBody UserType req, Model model) {
        List<UserType> newPerson = new ArrayList<>();


        try {
            //pass req body to create method on CRUDRepository
            newPerson.add(req);
            userRepo.save(newPerson);
//            = userRepo.save(req);
            newPerson.add(req);
            //assign the users List to the model to call ${users} view variable
            model.addAttribute("users", newPerson);
            //return the name of the view
            return "layout";

        } catch (Exception e) {
            model.addAttribute("exception", e.getMessage()); //pass exception message to model
        }
        //render message from model on errorPage fragment
        return "errorPage";
    }

}
