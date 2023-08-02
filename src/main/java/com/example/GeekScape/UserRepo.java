package com.example.GeekScape;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepo extends CrudRepository<UserType, Long> {
    List<UserType> findByUsername(@Param("username") String username);
//    List<UserType> save(UserType userType);
//    <List extends UserType> List save(List req);

    List<UserType> save(List req);
}
