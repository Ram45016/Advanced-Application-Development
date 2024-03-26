package com.example.partyarchitect.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.partyarchitect.Model.User;


public interface UserRepository extends JpaRepository<User,Long>{
    Optional<User> findByName(String name);
    
    
}
