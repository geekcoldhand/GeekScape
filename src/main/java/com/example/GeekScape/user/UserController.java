package com.example.GeekScape.user;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    private final UserRepo userRepo;

    @Autowired
    public UserController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping("/all-users")
    public List<UserType> getAllUsers() {
        ArrayList allUsers = new ArrayList<>();
        if(userRepo.findAll() != null){
            allUsers = (ArrayList) userRepo.findAll();
        }
        return allUsers;
    }

    @GetMapping("/users")
    public UserType getUserById(Long id) {
        if(userRepo.findUserById(id) != null){
            return userRepo.findUserById(id);
        }
        return new UserType();
    }

    @PostMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public UserType createNewUser(@RequestBody UserType req) {
        UserType user = req;
        userRepo.save(user);
        return user;

    }


}
