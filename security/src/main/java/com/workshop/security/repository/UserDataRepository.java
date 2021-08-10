package com.workshop.security.repository;

import java.util.Optional;

import com.workshop.security.model.UserData;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDataRepository extends JpaRepository <UserData,Integer> {
    
    Optional <UserData>  findByUserName(String userName);

    Optional <UserData> findById(int id);
}
