package com.example.GeekScape;

import org.h2.engine.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class UserController {

    private UserRepo userRepo;

    @Autowired
    public UserController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping("/user")
    public String getAllUsers(Model model) {
        try{
            Iterable<UserType> allUsers = userRepo.findAll();
            model.addAttribute("users", allUsers);
            return "layout"; //returns the mainFeed view fragment

        }catch (Exception e){
            model.addAttribute("exception", e.getMessage());

        }
        return "errorPage";
    }

    @PostMapping("/user")
    public String createNewUser(@RequestBody List req, Model model) {
//
        try {
            List<UserType>  newPerson = userRepo.save(req);
            model.addAttribute("name", "horatiuos");
            return "redirect";

        }catch (Exception e ){
            model.addAttribute("exception", e.getMessage());
        }
        //send errorPage fragment
        return "errorPage";
    }

}
