package com.example.GeekScape;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class Vein {
    private String veinType;
    private String veinLocation;
    private List<User> localUsers;


    public void findUsersInVeinType(String location){

        List<User> usersInVein = new ArrayList<>();

        //check location with veinLocation
        // check users in the location of that veinType
        // add them the localUsers;

        this.localUsers = usersInVein;
    }

    public String getVeinType() {
        return veinType;
    }

    public void setVeinType(String veinType) {
        this.veinType = veinType;
    }

    public String getVeinLocation() {
        return veinLocation;
    }

    public void setVeinLocation(String veinLocation) {
        this.veinLocation = veinLocation;
    }

    public List<User> getLocalUsers() {
        return localUsers;
    }

    public void setLocalUsers(List<User> localUsers) {
        this.localUsers = localUsers;
    }


}
