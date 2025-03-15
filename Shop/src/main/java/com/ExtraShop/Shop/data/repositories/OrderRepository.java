package com.ExtraShop.Shop.data.repositories;

import com.ExtraShop.Shop.models.CartItem;
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
import java.util.LinkedList;


@Service
public class OrderRepository  {

    private final CartRepository cartRepository;

    public OrderRepository( CartRepository cartRepository){
        this.cartRepository = cartRepository;
    }
    public LinkedList<Order> getAllOrders(int userId,Connection connection)throws Exception{
        var orders = new LinkedList<Order>();


           Statement statement = connection.createStatement();

            ResultSet result = statement.executeQuery("SELECT * FROM orders where userId ="+ userId);
            while (result.next()) {
                var order = new Order();
                order.setId(result.getInt("id"));
                order.setUserId(result.getInt("userId"));
                order.setTotalAmount(result.getInt("totalAmount"));
                order.setStatusId(result.getInt("statusId"));
                order.setDeliveryAddress(result.getString("deliveryAddress"));
                order.setEmail(result.getString("email"));
                order.setPaymentTypeId(result.getInt("paymentTypeId"));
                order.setPhone(result.getString("phone"));
                orders.add(order);
            }

            result.close();
            statement.close();
           return orders;
}
    public Order addOrder(Order order, Connection connection) throws Exception {
        Statement statement = connection.createStatement();
        int id = 0;

        String query = "INSERT INTO orders (user_id, total_amount, status_id, delivery_address, " +
                "email, payment_type_id, phone) VALUES (" +
                order.getUserId() + ", " +
                calculateTotalAmount(order.getUserId(), connection) + ", " +
                1 + ", '" +
                order.getDeliveryAddress() + "', '" +
                order.getEmail() + "', " +
                order.getPaymentTypeId() + ", '" +
                order.getPhone() + "')";
        ResultSet result = statement.executeQuery("select lastval()");
        if (result.next()) {
            id = result.getInt(1);
        }
        var cartItems = cartRepository.GetCart(order.getUserId(), connection);
        String insertOrderItemsQuery = "INSERT INTO order_items (order_id, product_id, quantity, price ) VALUE ";
        for (CartItem item : cartItems) {
            insertOrderItemsQuery += "(" + id + "," + item.getProductId() + "," + item.getQuantity() + "," + item.getProduct().getPrice() * item.getQuantity() + "),";
        }
        statement.executeUpdate(insertOrderItemsQuery);
        statement.close();


        return GetOrderById(id, connection);
    }
        public Order GetOrderById( int id, Connection connection) throws Exception {
            var preparedStatement = connection.createStatement();;

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


    private double calculateTotalAmount(int userid, Connection connection) throws Exception {
        var statement = connection.createStatement();
       var result = statement.executeQuery("SELECT sum( cartitem.quantity * price) as totalAmount FROM cartitem \n" +
                "JOIN products on productid = id\n" +
                "WHERE userid = "+ userid);
       result.next();
        double totalAmount = result.getDouble("totalAmount");
        result.close();
        statement.close();
        return totalAmount;

    }
    public Order getOrderById(int id, Connection connection)throws Exception{
        var statement = connection.createStatement();
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



