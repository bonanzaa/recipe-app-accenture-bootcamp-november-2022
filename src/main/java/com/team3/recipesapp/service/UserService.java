package com.team3.recipesapp.service;

import com.team3.recipesapp.model.User;
import com.team3.recipesapp.repository.UserRepository;
import com.team3.recipesapp.security.ApplicationSecurityConfig;
import com.team3.recipesapp.utility.UsernameOrEmailAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void saveUser(User user) {
        if (
                userRepository.findByEmail(user.getEmail()).isEmpty()
                        && userRepository.findByUsername(user.getUsername()).isEmpty()) {
            userRepository.save(user);
        } else throw new UsernameOrEmailAlreadyExistsException();
    }

    public void delete(User user) {
        userRepository.delete(user);
    }

    public void deleteById(String id) {
        userRepository.deleteById(id);
    }

    public User replaceUser(User newUser, String id) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setUsername(newUser.getUsername());
                    user.setEmail(newUser.getEmail());
                    if (newUser.getPassword() != null) {
                        user.setPassword(ApplicationSecurityConfig.passwordEncoder().encode(newUser.getPassword()));
                    }
                    if (newUser.getRole() == null) {
                        user.setRole("ROLE_USER");
                    } else {
                        user.setRole(newUser.getRole());
                    }
                    return userRepository.save(user);
                })
                .orElseGet(() -> {
                    newUser.setID(id);
                    return userRepository.save(newUser);
                });
    }

}
