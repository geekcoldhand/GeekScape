package com.example.GeekScape;


import org.h2.engine.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<UserType, Long> {
    List<UserType> findByUsername(@Param("username") String username);
    @Override
    List<UserType> findAll();

    void save(List<UserType> newPerson);
}
