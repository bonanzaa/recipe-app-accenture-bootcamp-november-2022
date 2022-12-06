package com.team3.recipesapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;
import java.sql.*;
import java.util.*;
import java.util.logging.Logger;

@SpringBootApplication
public class RecipesAppApplication {

    private static final Logger log;

    static {
        System.setProperty("java.util.logging.SimpleFormatter.format", "[%4$-7s] %5$s %n");
        log =Logger.getLogger(RecipesAppApplication.class.getName());
    }

    public static void main(String[] args) {
        SpringApplication.run(RecipesAppApplication.class, args);

        log.info("Loading application properties");
        Properties properties = new Properties();
        try {
            properties.load(TestUser.class.getClassLoader().getResourceAsStream("application.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        log.info("Connecting to the database");
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(properties.getProperty("url"), properties);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        TestUser a = new TestUser(75,"aaznanob","asd321");
        try {
            insertData(a,connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        log.info("Insertion successful");
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private static void insertData(TestUser todo, Connection connection) throws SQLException {
        log.info("Insert data");
        PreparedStatement insertStatement = connection
                .prepareStatement("INSERT INTO TestUser (UserId, Username, Password) VALUES (?, ?, ?);");

        insertStatement.setInt(1, todo.getID());
        insertStatement.setString(2, todo.getUsername());
        insertStatement.setString(3, todo.getPassword());
        insertStatement.executeUpdate();
    }



}
