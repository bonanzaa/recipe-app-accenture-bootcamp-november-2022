package com.team3.recipesapp.service;

import com.team3.recipesapp.model.User;
import com.team3.recipesapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public void delete(User user){ userRepository.delete(user);}
    public void deleteById(String id){
        userRepository.deleteById(id);
    }

    public User replaceUser(User newUser,String id){
        return userRepository.findById(id)
                .map(user -> {
                    user.setUsername(newUser.getUsername());
                    user.setEmail(newUser.getEmail());
                    user.setPassword(newUser.getPassword());
                    user.setRole(newUser.getRole());

                    return userRepository.save(user);
                })
                .orElseGet(() -> {
                    newUser.setID(id);
                    return userRepository.save(newUser);
                });
    }
}
