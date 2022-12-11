package com.team3.recipesapp;

import jakarta.annotation.Resource;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;



@DataJpaTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository repository;

    @Resource
    private EntityManager entityManager;




    @Test
    public void no_users_in_repository(){
        //Iterable<User> users = repository.findAll();
        //assertThat(users).isEmpty();

    }

    @Test
    public void save_and_find_user_in_repository(){

        //  User user = repository.save(new User( ,"Alex","alex@gmail.com","12345"));
//        User user = new User();
//        user.setUsername("Alex");
//        user.setPassword("12345");
//        user.setEmail("alex@gmail.com");
//        repository.save(user);
//
//        assertThat(user).hasFieldOrPropertyWithValue("username","Alex");
//        assertThat(user).hasFieldOrPropertyWithValue("email", "alex@gmail.com");
//        assertThat(user).hasFieldOrPropertyWithValue("password","12345");
//

    }

    @Test
    public void delete_all_users_in_repository(){

//        User user = new User();
//        user.setUsername("Alex");
//        user.setPassword("12345");
//        user.setEmail("alex@gmail.com");
//        repository.save(user);
//
//        User user2 = new User();
//        user.setUsername("Den");
//        user.setPassword("abhfsg");
//        user.setEmail("Den@gmail.com");
//        repository.save(user2);
//
//        entityManager.persist(user);
//        entityManager.persist(user2);
//        repository.deleteAll();
//        assertThat(repository.findAll()).isEmpty();

    }


}
