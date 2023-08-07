package com.example.GeekScape;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Entity
public class UserType {
    public UserType(Long id, String username, String email, String password, String profileGif, String location, LocalDate dob) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.profileGif = profileGif;
        this.location = location;
        this.dob = dob;
    }

    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String email;
    private String password;
    private String profileGif;
    private String location;
    @Transient
    private Integer age;
    private LocalDate dob;

    protected UserType() {
    }

    public UserType(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public UserType(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public UserType(String email, String username, String password, LocalDate dob) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.dob = dob;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfileGif() {
        return profileGif;
    }

    public void setProfileGif(String profileGif) {
        this.profileGif = profileGif;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDate getDob() {return dob;}

    public void setDob(LocalDate dob) {this.dob = dob;}

    public Integer getAge() {return Period.between(this.dob, LocalDate.now()).getYears();}

    public void setAge(Integer age) {this.age = age;}
}
