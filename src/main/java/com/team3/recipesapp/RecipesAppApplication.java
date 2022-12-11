package com.team3.recipesapp;

import com.azure.core.annotation.Post;
import com.azure.core.annotation.Get;
import org.hibernate.annotations.Target;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.lang.annotation.ElementType;
import java.sql.*;
import java.util.*;
import java.util.logging.Logger;

@RestController
@SpringBootApplication
public class RecipesAppApplication {

    private static final Logger log;

    static {
        System.setProperty("java.util.logging.SimpleFormatter.format", "[%4$-7s] %5$s %n");
        log =Logger.getLogger(RecipesAppApplication.class.getName());
    }

    //test

    public static void main(String[] args) {
        connectToDB();
        SpringApplication.run(RecipesAppApplication.class, args);
    }

    private static void connectToDB(){
        log.info("Loading application properties.");
        Properties properties = new Properties();
        try {
            properties.load(TestUser.class.getClassLoader().getResourceAsStream("application.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            log.info("Application Properties loaded successfully.");
        }

        log.info("Connecting to the database.");
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(properties.getProperty("url"), properties);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            log.info("Connection to the Database established successfully.");
        }

        log.info("Closing connection.");
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            log.info("Connection closed.");
        }
    }

    private static void insertData(TestUser todo, Connection connection) throws SQLException {
        log.info("Inserting data into Database.");
        PreparedStatement insertStatement = connection
                .prepareStatement("INSERT INTO TestUser (UserId, Username, Password) VALUES (?, ?, ?);");

        insertStatement.setInt(1, todo.getID());
        insertStatement.setString(2, todo.getUsername());
        insertStatement.setString(3, todo.getPassword());
        insertStatement.executeUpdate();
    }



}
