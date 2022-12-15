package com.team3.recipesapp.repository;

import com.team3.recipesapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,String>{

    Optional<User> findByUsername(String username);
}
