package com.example.GeekScape.user;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import jakarta.persistence.*;
import org.hibernate.annotations.Type;

import java.time.LocalDate;
import java.time.Period;


@Entity
@Table(name = "users")
public class UserType {
    @Id
    @GeneratedValue
    @Column(name = "id", columnDefinition = "BIGINT")
    private Long id;

    @Column(name = "username", columnDefinition = "VARCHAR(255)")
    private String username;

    @Column(name = "email", nullable = false, columnDefinition = "VARCHAR(255)")
    private String email;

    @Column(name = "password", nullable = false, columnDefinition = "VARCHAR(255)")
    private String password;

    @Column(name = "profile_gif", columnDefinition = "VARCHAR(255)")
    private String profileGif;

    @Column(name = "location", columnDefinition = "VARCHAR(255)")
    private String location;

    @Transient
    private Integer age;

    @Column(name = "dob", columnDefinition = "DATE")
    private LocalDate dob;

    public UserType() {
    }

    public UserType(Long id, String email, String password) {
        this.email = email;
        this.password = password;
    }

    public UserType(Long id, String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public UserType(Long id, String email, String username, String password, LocalDate dob) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.dob = dob;
    }
    public UserType(Long id, String username, String email, String password, String profileGif, String location, LocalDate dob) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.profileGif = profileGif;
        this.location = location;
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

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getAge() {
        return Period.between(
                this.dob, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
