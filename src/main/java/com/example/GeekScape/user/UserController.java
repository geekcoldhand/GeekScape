package com.example.GeekScape.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserRepo userRepo;

    @Autowired
    private UserService userService;

    @Autowired
    protected UserController(UserRepo userRepo, UserService userService) {
        this.userRepo = userRepo;
        this.userService = userService;

    }

    @GetMapping("all-users")
    public List<UserType> getAllUsers() {
        List allUsers = new ArrayList<>();
        if(userService.allUsers() != null){
            allUsers = userService.allUsers();
        }
        return allUsers;
    }

    @GetMapping("/{id}")
    public UserType getUserById(@PathVariable("id") @NonNull Long id) {
        if(userService.getById(id) != null){
            return userService.getById(id);
        }
        return new UserType();
    }

    @PostMapping
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
