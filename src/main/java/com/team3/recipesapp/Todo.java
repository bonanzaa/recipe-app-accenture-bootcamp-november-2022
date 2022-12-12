package com.team3.recipesapp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Todo {
    public Todo(){}

    public Todo(String description, boolean done){
        this.description = description;
        this.done = done;
    }

    @Id
    @GeneratedValue
    public Long id;
    public String description;
    public boolean done;
}
