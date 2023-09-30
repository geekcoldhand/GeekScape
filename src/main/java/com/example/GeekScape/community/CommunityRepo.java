package com.example.GeekScape.community;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
 interface CommunityRepo extends JpaRepository<CommunityEntity, Long> {

    @Override
    List<CommunityEntity> findAll();
}
