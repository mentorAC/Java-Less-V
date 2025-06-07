package com.ExtraShop.Shop.controllers;

import com.ExtraShop.Shop.Services.JwtTokenService;
import com.ExtraShop.Shop.data.repositories.OrderRepository;
import com.ExtraShop.Shop.data.repositories.OrderRepository;
import com.ExtraShop.Shop.models.Order;
import com.ExtraShop.Shop.utils.Constants;
import com.ExtraShop.Shop.utils.DbUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


@RestController
@RequestMapping("/order")
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController extends ControllerBase {

    private final OrderRepository orderRepository;
    private final JwtTokenService tokenService;

    public OrderController(OrderRepository orderRepository, JwtTokenService tokenService) {
        this.orderRepository = orderRepository;
        this.tokenService = tokenService;
    }

    @GetMapping("/get-all-orders")
    public ResponseEntity GetAllOrders(@RequestHeader(Constants.AUTH_HEADER) String header) {
        var token = header.split(" ")[1];
        if (!Authorization(tokenService, token)) return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        var userId = tokenService.extractUserId(token);
        return Handler(connection -> ResponseEntity.ok(orderRepository.getAllOrders(userId, connection)));

    }

    @GetMapping("/get-by-id/{id}")
    public ResponseEntity GetOrderById(@PathVariable int id) {
        return Handler(connection -> ResponseEntity.ok(orderRepository.getOrderById(id, connection)));

    }

    @PostMapping("/add")
    public ResponseEntity addOrder(@RequestBody Order order, @RequestHeader(Constants.AUTH_HEADER) String header) {
        var token = header.split(" ")[1];
        if (!Authorization(tokenService, token)) return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        var userId = tokenService.extractUserId(token);
        order.setUserId(userId);
        return Handler(connection -> ResponseEntity.ok(orderRepository.addOrder(order, connection)));
    }
    @PutMapping("/changeStatus/{order_id}/{status_id}")
    public ResponseEntity changeStatus(@PathVariable int order_id, @PathVariable int status_id){
        return Handler(connection -> {
                    orderRepository.changeStatus(order_id, status_id, connection);
            return new ResponseEntity<>(HttpStatus.OK);
        });
    }
}


