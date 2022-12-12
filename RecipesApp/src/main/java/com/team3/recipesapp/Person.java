package com.team3.recipesapp;

public class Person {
    private String name;
    private int age;
    private int recipesCreated;

    public Person(String name, int age, int recipesCreated) {
        this.name = name;
        this.age = age;
        this.recipesCreated = recipesCreated;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getRecipesCreated() {
        return recipesCreated;
    }

    public void setRecipesCreated(int recipesCreated) {
        this.recipesCreated = recipesCreated;
    }
}
