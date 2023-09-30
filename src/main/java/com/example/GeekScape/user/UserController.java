package com.example.GeekScape.user;

import jakarta.servlet.http.HttpServletResponse;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class UserController {
    private final UserRepo userRepo;

    @Autowired
    private UserService userService;

    @Autowired
    public UserController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping("all-users")
    public List<UserType> getAllUsers() {
        List allUsers = new ArrayList<>();
        if(userService.allUsers() != null){
            allUsers = userService.allUsers();
        }
        return allUsers;
    }

    @GetMapping("users/{id}")
    public UserType getUserById(@PathVariable("id") @NonNull Long id) {
        if(userService.getById(id) != null){
            return userService.getById(id);
        }
        return new UserType();
    }

    @PostMapping(value = "users", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<UserType> createNewUser(@RequestBody UserType req) {
        UserType savedUser = new UserType();
        UserType reqUser = new UserType();
        if(req != null){
            reqUser = req;
            savedUser = userService.add(reqUser);
        }

    return new ResponseEntity<UserType>(reqUser, HttpStatus.CREATED);

    }


}
