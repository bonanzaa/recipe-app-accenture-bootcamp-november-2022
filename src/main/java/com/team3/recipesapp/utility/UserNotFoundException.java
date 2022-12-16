package com.team3.recipesapp.utility;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String id){
        super("Could not find user with ID: " + id);
    }
}
