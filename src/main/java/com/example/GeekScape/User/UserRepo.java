package com.example.GeekScape.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<UserType, Long> {
   int createUser(UserType newPerson);

    @Override
    List<UserType> findAll();

    @Query("SELECT u FROM Users u WHERE u.username = :username")
    List<UserType> findByUsername(String username);

    UserType findUserById(long l);

}
