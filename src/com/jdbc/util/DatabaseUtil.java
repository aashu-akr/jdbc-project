package com.jdbc.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {

    private static final String DRIVER_PATH = "com.mysql.cj.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/jdbcdb";
    private static final String DATABASE_USER = "root";
    private static final String DATABASE_PASSWORD = "aashu150198";
    public DatabaseUtil(){
        try{
            Class.forName(DRIVER_PATH);
        }catch (Exception e)
        {
           throw  new RuntimeException("something went wrong...." + e);
        }
    }//end of the constructor

    public Connection getConnection() throws SQLException { //thorws sql exception
       return  DriverManager.getConnection(DATABASE_URL,DATABASE_USER,DATABASE_PASSWORD);
    }
}
