package com.team3.recipesapp.model;

//import com.team3.recipesapp.security.userRole;
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
    private int accountnonexpired;
    private int accountnonlocked;
    private int credentialsnonexpired;
    private int enabled;

    public User(String username,String email,String password){
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = "ROLE_USER";
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
        return this.role;
    }
    public void setRole(String newRole){
        this.role = newRole;
    }

    public boolean getIsAccountNonExpired() {
        if(accountnonexpired == 1) return true;

        return false;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        if(accountNonExpired) {
            accountnonexpired = 1;
        }else{
            accountnonexpired = 0;
        }
    }

    public boolean getIsAccountNonLocked() {
        if(accountnonlocked == 1) return true;

        return false;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        if(accountNonLocked) {
            accountnonlocked = 1;
        }else{
            accountnonlocked = 0;
        }
    }

    public boolean getIsCredentialsNonExpired() {
        if(credentialsnonexpired == 1) return true;

        return false;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        if(credentialsNonExpired) {
            credentialsnonexpired = 1;
        }else{
            credentialsnonexpired = 0;
        }
    }

    public boolean getIsEnabled() {
        if(enabled == 1) return true;

        return false;
    }

    public void setEnabled(boolean enabled) {
        if(enabled) {
            this.enabled = 1;
        }else{
            this.enabled = 0;
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
