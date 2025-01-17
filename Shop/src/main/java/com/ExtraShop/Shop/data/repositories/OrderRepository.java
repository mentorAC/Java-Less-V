package com.ExtraShop.Shop.data.repositories;

import com.ExtraShop.Shop.models.Order;
import com.ExtraShop.Shop.utils.DbUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;




@Service
public class OrderRepository  {
    private final DbContextService dbContextService;

    public OrderRepository(DbContextService dbContextService){
        this.dbContextService = dbContextService;
    }
    public Order getOrderById(int id)throws Exception{
        var statement = dbContextService.getConnection().createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM Products WHERE id = "+id);
        Order order = null;
        while(result.next()){
            order = new Order();
            order.setId(result.getInt("id"));
            order.setUserId(result.getInt("userId"));
            order.setStatusAmount(result.getInt("statusAmount"));
            order.setStatusId(result.getInt("statusId"));
            order.setDeliveryAddress(result.getString("deliveryAddress"));
            order.setEmail(result.getString("email"));
            order.setPaymentTypeId(result.getInt("paymentTypeId"));
            order.setPhone(result.getString("phone"));
            break;
        }
        statement.close();

        return order;
    }
}



