//package com.ExtraShop.Shop.controllers;
//
//import com.ExtraShop.Shop.data.repositories.OrderRepository;
//import com.ExtraShop.Shop.data.repositories.OrderRepository;
//import com.ExtraShop.Shop.models.Order;
//import com.ExtraShop.Shop.utils.DbUtils;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatusCode;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import javax.swing.plaf.nimbus.State;
//import java.sql.*;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.Statement;
//
//import java.util.Arrays;
//import java.util.LinkedList;
//import java.util.List;
//
//
//@RestController
//@RequestMapping("/order")
//@CrossOrigin(origins = "http://localhost:4200")
//public class OrderController {
//
//    private final OrderRepository orderRepository;
//
//    public OrderController(OrderRepository orderRepository) {
//        this.orderRepository = orderRepository;
//    }
//
//    @GetMapping("/get-all-orders")
//    public ResponseEntity GetAllOrders() {
//        var orders = new LinkedList<Order>();
//
//        Connection connection = null;
//        Statement statement = null;
//
//        try {
//            connection = DbUtils.createConnection();
//            statement = connection.createStatement();
//
//            ResultSet result = statement.executeQuery("SELECT * FROM orders");
//            while (result.next()) {
//                var order = new Order();
//                order.setId(result.getInt("id"));
//                order.setUserId(result.getInt("userId"));
//                order.setStatusAmount(result.getInt("statusAmount"));
//                order.setStatusId(result.getInt("statusId"));
//                order.setDeliveryAddress(result.getString("deliveryAddress"));
//                order.setEmail(result.getString("email"));
//                order.setPaymentTypeId(result.getInt("paymentTypeId"));
//                order.setPhone(result.getString("phone"));
//                orders.add(order);
//            }
//
//            result.close();
//            statement.close();
//            connection.close();
//            return ResponseEntity.ok(orders);
//
//        } catch (Exception ex) {
//            System.out.println(ex);
//        }
//
//        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//
//    @GetMapping("/get-by-id/{id}")
//    public ResponseEntity GetOrderById(@PathVariable int id) {
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//
//        try {
//            connection = DbUtils.createConnection();
//            String query = "SELECT * FROM orders WHERE id = ?";
//            preparedStatement = connection.prepareStatement(query);
//            preparedStatement.setInt(1, id);
//
//            ResultSet result = preparedStatement.executeQuery();
//
//            if (result.next()) {
//                var order = new Order();
//                order.setId(result.getInt("id"));
//                order.setUserId(result.getInt("userId"));
//                order.setStatusAmount(result.getInt("statusAmount"));
//                order.setStatusId(result.getInt("statusId"));
//                order.setDeliveryAddress(result.getString("deliveryAddress"));
//                order.setEmail(result.getString("email"));
//                order.setPaymentTypeId(result.getInt("paymentTypeId"));
//                order.setPhone(result.getString("phone"));
//
//                result.close();
//                preparedStatement.close();
//                connection.close();
//
//                return ResponseEntity.ok(order);
//            }
//
//            result.close();
//            preparedStatement.close();
//            connection.close();
//            return new ResponseEntity(HttpStatus.NOT_FOUND);
//
//        } catch (Exception ex) {
//            System.out.println(ex);
//        }
//
//        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//
//    @PostMapping("/add")
//    public ResponseEntity AddOrder(@RequestBody Order order) {
//        Connection connection = null;
//        Statement statement = null;
//        int id = 0;
//
//        try {
//            // Устанавливаем соединение с базой данных
//            connection = DbUtils.createConnection();
//
//            // Формируем SQL-запрос для вставки
//            String query = "INSERT INTO orders (user_id, status_amount, status_id, delivery_address, email, payment_type_id, phone) VALUES (" +
//                    order.getUserId() + ", " +
//                    order.getStatusAmount() + ", " +
//                    order.getStatusId() + ", '" +
//                    order.getDeliveryAddress() + "', '" +
//                    order.getEmail() + "', " +
//                    order.getPaymentTypeId() + ", '" +
//                    order.getPhone() + "')";
//
//            statement = connection.createStatement();
//
//            int rowsAffected = statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
//
//            if (rowsAffected > 0) {
//                ResultSet generatedKeys = statement.getGeneratedKeys();
//                if (generatedKeys.next()) {
//                    id = generatedKeys.getInt(1);
//                }
//                generatedKeys.close();
//            }
//
//            statement.close();
//            connection.close();
//
//        } catch (Exception ex) {
//            System.out.println(ex);
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//        return GetOrderById(id);
//    }
//
//
//}
//
//
