package com.example.GeekScape;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepo extends CrudRepository<UserType, Long> {
    List<UserType> findByUsername(@Param("username") String username);
    List<UserType> saveNewUser(UserType userType);
}
