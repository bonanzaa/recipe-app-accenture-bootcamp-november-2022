package com.team3.recipesapp.security;

public enum UserPermission {
    RECIPE_READ("recipe:read"),
    RECIPE_WRITE("recipe:write"),
    USER_READ("user:read"),
    USER_WRITE("user:write"),
    USER_DELETE("user:delete"),
    USER_EDIT("user:edit");

    private final String permission;

    UserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
