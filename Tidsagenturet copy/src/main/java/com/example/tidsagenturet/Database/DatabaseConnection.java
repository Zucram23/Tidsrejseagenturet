package com.example.tidsagenturet.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://tidsagenturet/";
    private static final String USER = "root";
    private static final String PASSWORD = "Rhselev6687";

    public static Connection getConnection()  {


        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
           e.printStackTrace();
           return null;
        }
    }

}
