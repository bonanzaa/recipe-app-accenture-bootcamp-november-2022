package com.team3.recipesapp.utility;

public class UsernameOrEmailAlreadyExistsException extends RuntimeException {
    public UsernameOrEmailAlreadyExistsException() {
        super("Username or email already exists");
    }
}
