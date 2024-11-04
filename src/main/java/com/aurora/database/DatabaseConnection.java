package com.aurora.database;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class DatabaseConnection {
    private static String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String DB_URL = "jdbc:mysql://localhost:3306/dbmediateca?useSSL=false";
    private static String DB_USER = "lemus";
    private static String DB_PASSWORD = "lemus";
    private static Driver driver = null;

    private static final Logger logger = LogManager.getLogger();

    public static synchronized Connection getConnection() throws SQLException {
        Connection conn = null;
        if (driver == null) {
            try {
            Class jdbcDriverClass = Class.forName(JDBC_DRIVER);
            driver = (Driver) jdbcDriverClass.newInstance();
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            }catch (SQLException e){
                System.out.println(e.getMessage());
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        logger.info("Connection established...ok.");
        return conn;
    }


    //Cierre del resultSet
    public static void close(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
    //Cierre del PrepareStatement
    public static void close(PreparedStatement stmt) {
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
    public static void close(Connection conn) {//Cierre de la conexion
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
}
