package com.team3.recipesapp.security;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static com.team3.recipesapp.security.UserPermission.*;

public enum UserRole{
    USER(newHashSet(RECIPE_READ, RECIPE_WRITE, USER_READ)),
    MODERATOR(newHashSet(RECIPE_READ, RECIPE_WRITE, USER_READ, USER_EDIT)),
    ADMIN(newHashSet(RECIPE_READ, RECIPE_WRITE, USER_READ, USER_WRITE, USER_EDIT, USER_DELETE));

    private final Set<UserPermission> permissions;

    UserRole(Set<UserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
        Set<SimpleGrantedAuthority> permissions =
                getPermissions()
                        .stream()
                        .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                        .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return permissions;
    }

    public Set<UserPermission> getPermissions() {
        return permissions;
    }

    private static <T> Set<T> newHashSet(T... objs) {
        Set<T> set = new HashSet<T>();
        Collections.addAll(set, objs);
        return set;
    }
}
