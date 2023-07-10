package com.example.GeekScape;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String password;
    private String name;
    private String profileGif;
    private Integer phoneNumber;
    private Integer age;
    private String location;
    private Archetype archetype;
    private List<String> socailLinks;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfileGif() {
        return profileGif;
    }

    public void setProfileGif(String profileGif) {
        this.profileGif = profileGif;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Archetype getArchetype() {
        return archetype;
    }

    public void setArchetype(Archetype archetype) {
        this.archetype = archetype;
    }

    public List<String> getSocailLinks() {
        return socailLinks;
    }

    public void setSocailLinks(List<String> socailLinks) {
        this.socailLinks = socailLinks;
    }


}
