package com.ExtraShop.Shop.data.repositories;

import com.ExtraShop.Shop.models.Order;
import com.ExtraShop.Shop.utils.DbUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;




@Service
public class OrderRepository  {
    private final DbContextService dbContextService;

    public OrderRepository(DbContextService dbContextService){
        this.dbContextService = dbContextService;
    }
    public Order addOrder(Order order) throws Exception {
        Statement statement = dbContextService.getConnection().createStatement();
        int id = 0;
        String query = "INSERT INTO orders (user_id, total_amount, status_id, delivery_address, " +
                "email, payment_type_id, phone) VALUES (" +
                order.getUserId() + ", " +
                calculateTotalAmount(order.getUserId()) + ", " +
                1 + ", '" +
                order.getDeliveryAddress() + "', '" +
                order.getEmail() + "', " +
                order.getPaymentTypeId() + ", '" +
                order.getPhone() + "')";
        ResultSet result = statement.executeQuery("select lastval()");
        if (result.next()) {
            id = result.getInt(1);
        }
        statement.close();


        return GetOrderById(id);
    }
        public Order GetOrderById( int id) throws Exception {
            var preparedStatement = dbContextService.getConnection().createStatement();;

                String query = "SELECT * FROM orders WHERE id = ?";
                ResultSet result = preparedStatement.executeQuery(query);
            var order = new Order();

                if (result.next()) {

                    order.setId(result.getInt("id"));
                    order.setUserId(result.getInt("userId"));
                    order.setTotalAmount(result.getInt("totalAmount"));
                    order.setStatusId(result.getInt("statusId"));
                    order.setDeliveryAddress(result.getString("deliveryAddress"));
                    order.setEmail(result.getString("email"));
                    order.setPaymentTypeId(result.getInt("paymentTypeId"));
                    order.setPhone(result.getString("phone"));

                    result.close();
                    preparedStatement.close();
                }

                result.close();
                preparedStatement.close();
                return order;

            }


    private double calculateTotalAmount(int userid) throws Exception {
        var statement = dbContextService.getConnection().createStatement();
       var result = statement.executeQuery("SELECT sum( cartitem.quantity * price) as totalAmount FROM cartitem \n" +
                "JOIN products on productid = id\n" +
                "WHERE userid = "+ userid);
       result.next();
        double totalAmount = result.getDouble("totalAmount");
        result.close();
        statement.close();
        return totalAmount;

    }
    public Order getOrderById(int id)throws Exception{
        var statement = dbContextService.getConnection().createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM Products WHERE id = "+id);
        Order order = null;
        while(result.next()){
            order = new Order();
            order.setId(result.getInt("id"));
            order.setUserId(result.getInt("userId"));
            order.setTotalAmount(result.getInt("totalAmount"));
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



