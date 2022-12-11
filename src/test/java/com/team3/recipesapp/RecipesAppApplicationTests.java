package com.team3.recipesapp;

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


//    @Mock
//    private TestUser user;

    @Test
    public void check_a_user_properties(){
//        TestUser testuser = new TestUser(1,"Alex", "12345");
//
//        assertThat(testuser).hasFieldOrPropertyWithValue("ID",1);
//        assertThat(testuser).hasFieldOrPropertyWithValue("username","Alex");
//        assertThat(testuser).hasFieldOrPropertyWithValue("password","12345");
    }

    @Test
    public void Check() throws Exception{
//        user = new TestUser();
//
//        when(resultSet.getInt(1)).thenReturn(user.getID());
//        when(resultSet.getString(2)).thenReturn(user.getUsername());
//        when(resultSet.getString(3)).thenReturn(user.getPassword());
    }

    @Test
    public void setUserDetails() {
//        user.setID(23);
//        user.setPassword("1234564565");
//        user.setUsername("Fredy");
    }




}
