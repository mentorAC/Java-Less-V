package com.ExtraShop.Shop.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class DbUtils {
    public static Connection createConnection() throws Exception{
        var connection =  DriverManager.getConnection("jdbc:postgresql://localhost:5432/shop", "postgres", "postgrespw");
        connection.setAutoCommit(false);
        return connection;
    }
}
