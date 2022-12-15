package com.team3.recipesapp;

import com.team3.recipesapp.model.User;
import com.team3.recipesapp.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.IOException;
import java.sql.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

@SpringBootApplication
@ComponentScan(basePackages={"com.team3.recipesapp"})
public class RecipesAppApplication {

    private static final Logger log;

    static {
        System.setProperty("java.util.logging.SimpleFormatter.format", "[%4$-7s] %5$s %n");
        log =Logger.getLogger(RecipesAppApplication.class.getName());
    }

    public static void main(String[] args) {
        connectToDB();
        log.info("Starting timeout before running the app.");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("Timeout over. Starting the application.");
        SpringApplication.run(RecipesAppApplication.class, args);
    }

    private static void connectToDB(){
        log.info("Loading application properties.");
        Properties properties = new Properties();
        try {
            properties.load(RecipesAppApplication.class.getClassLoader().getResourceAsStream("application.properties"));
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

        log.info("Database woken up.");
    }
    
}
