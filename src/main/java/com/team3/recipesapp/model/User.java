package com.team3.recipesapp.model;

import com.team3.recipesapp.utility.userRole;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.Objects;

@Entity
@Table(name="users")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class User {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;
    public String role;
    private String username;
    private String email;
    private String password;
    private int isAccountNonExpiredBit = 1;
    private int isAccountNonLockedBit = 1;
    private int isCredentialsNonExpiredBit = 1;
    private int isEnabledBit = 1;


    public User(String username,String email,String password){
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = userRole.DefaultUser.name();

        this.isAccountNonExpiredBit = 1;
        this.isAccountNonLockedBit = 1;
        this.isCredentialsNonExpiredBit = 1;
        this.isEnabledBit = 1;
    }

    public String getID(){
        return this.id;
    }
    public void setID(String id){
        this.id = id;
    }

    public String getUsername(){
        return this.username;
    }
    public void setUsername(String username){
        this.username = username;
    }

    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    public String getPassword(){
        return this.password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getRole(){
        return this.role.toString();
    }
    public void setRole(userRole newRole){
        this.role = newRole.name();
    }
    public boolean getIsAccountNonExpired() {
        if(isAccountNonExpiredBit == 1) return true;

        return false;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        if(accountNonExpired) {
            isAccountNonExpiredBit = 1;
        }else{
            isAccountNonExpiredBit = 0;
        }

    }

    public boolean getIsAccountNonLocked() {
        if(isAccountNonLockedBit == 1) return true;

        return false;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        if(accountNonLocked) {
            isAccountNonLockedBit = 1;
        }else{
            isAccountNonLockedBit = 0;
        }
    }

    public boolean getIsCredentialsNonExpired() {
        if(isCredentialsNonExpiredBit == 1) return true;

        return false;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        if(credentialsNonExpired) {
            isCredentialsNonExpiredBit = 1;
        }else{
            isCredentialsNonExpiredBit = 0;
        }
    }

    public boolean getIsEnabled() {
        if(isEnabledBit == 1) return true;

        return false;
    }

    public void setEnabled(boolean enabled) {
        if(enabled) {
            isEnabledBit = 1;
        }else{
            isEnabledBit = 0;
        }

    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof User))
            return false;
        User user = (User) o;
        return Objects.equals(this.id, user.id) && Objects.equals(this.username, user.username)
                && Objects.equals(this.email, user.email) && Objects.equals(this.role, user.role)
                && Objects.equals(this.password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.username, this.email, this.password,this.role);
    }

    @Override
    public String toString() {
        return "User{" + "id=" + this.id + ", userName='" + this.username + '\'' + ", email='" + this.email
                + '\'' + ", password='" + this.password + '\'' + ", role='" + this.role + '\'' + '}';
    }
}
