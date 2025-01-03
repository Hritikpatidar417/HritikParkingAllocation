package com.yash.parkingallocation.jdbcutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JdbcUtils {

    private final static String url="jdbc:mysql://localhost:3306/parking";
    private final static String username="root";
    private final static String password="root";

    public static Connection establishConnection()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver"); // Driver name
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("JDBC Connection Establish");
            return con;
        }catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
