package com.example.GeekScape.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public List<UserType> allUsers() {
        return userRepo.findAll();
    }

    public UserType getById(Long id) {
        return userRepo.findUserById(id);
    }

    public UserType add(UserType userType) {
        return userRepo.save(userType);
    }

    public UserType update(UserType userType, Long id) throws UserNotFoundException {
        if (userRepo.findById(id).isPresent()) {
            return userRepo.save(userType);
        }
        throw new UserNotFoundException("User Not Found");
    }


}
