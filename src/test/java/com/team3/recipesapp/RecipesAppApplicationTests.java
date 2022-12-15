package com.team3.recipesapp;

import com.team3.recipesapp.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import java.sql.*;
import org.mockito.Mock;
import org.junit.jupiter.api.Assertions;
@SpringBootTest
class RecipesAppApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void SimpleTest() {
        assertEquals(1,1);
    }


    @Mock
    private PreparedStatement insertStatement;
    @Mock
    private ResultSet resultSet;


    @Mock
    private User user;

    @Test
    public void check_a_user_properties(){
        User testuser = new User("testUser","Alex", "12345");

        assertThat(testuser).hasFieldOrPropertyWithValue("email","Alex");
        assertThat(testuser).hasFieldOrPropertyWithValue("username","testUser");
        assertThat(testuser).hasFieldOrPropertyWithValue("password","12345");
    }

    @Test
    public void setUserDetails() {
        user.setPassword("1234564565");
        user.setUsername("Fredy");
        user.setEmail("fredy@gmail.com");
    }




}
