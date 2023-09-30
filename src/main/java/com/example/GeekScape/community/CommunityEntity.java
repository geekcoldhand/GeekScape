package com.example.GeekScape.community;

import com.example.GeekScape.user.UserType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Entity
public class CommunityEntity  {
    @Id
    @GeneratedValue
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    private Enum domainName ;

    public List<UserType> getMembers() {
        return members;
    }

    public void setMembers(List<UserType> members) {
        this.members = members;
    }

    private List<UserType> members;
    public void enrollUser(){

    }



}
