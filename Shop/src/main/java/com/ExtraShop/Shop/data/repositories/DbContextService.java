//package com.ExtraShop.Shop.data.repositories;
//
//import com.ExtraShop.Shop.utils.DbUtils;
//import org.springframework.stereotype.Service;
//
//import java.sql.Connection;
//import java.sql.Statement;
//
//@Service
//public class DbContextService {
//
//    public void init(){
//        try {
//            Connection connection = DbUtils.createConnection();
//            connection.setAutoCommit(false);
//        }catch(Exception ex){
//            System.out.println(ex);
//        }
//    }
//    public void rollback(){
//        try {
//            connection.rollback();
//        }catch(Exception  ex){System.out.println(ex);
//        }
//    }
//
//    public Connection getConnection() {return connection;}
//    public void dispose()throws Exception{
//        connection.commit();
//        connection.close();
//    }
//}
