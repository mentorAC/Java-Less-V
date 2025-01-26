package com.ExtraShop.Shop.data.repositories;

import com.ExtraShop.Shop.utils.DbUtils;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.Statement;

@Service
public class DbContextService {
    private static Connection connection;
    public void init()throws Exception{
        connection = DbUtils.createConnection();
        connection.setAutoCommit(false);
    }
    public void rollback()throws Exception{
        connection.rollback();
    }

    public Connection getConnection() {return connection;}
    public void dispose()throws Exception{
        connection.commit();
        connection.close();
    }
}
