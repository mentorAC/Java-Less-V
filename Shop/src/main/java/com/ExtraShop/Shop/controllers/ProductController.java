package com.ExtraShop.Shop.controllers;

//import com.ExtraShop.Shop.data.entities.Product;
//import com.ExtraShop.Shop.data.repositories.ProductRepository;
//import com.ExtraShop.Shop.models.Product;
import com.ExtraShop.Shop.data.repositories.ProductRepository;
import com.ExtraShop.Shop.models.Product;
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
@RequestMapping("/product")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {
    private final ProductRepository productRepository;

    //GET
    //POST
    //PUT
    //DELETE
ProductController(ProductRepository productRepository){
    this.productRepository = productRepository;
}

    @GetMapping("/get-all-product")
    public ResponseEntity GetAllProduct(){

        var products = new LinkedList<Product>();//this.productRepository.getAll();

        Connection connection = null;
        Statement statement = null;
        try{
            connection = DbUtils.createConnection();
            statement = connection.createStatement();

            ResultSet result = statement.executeQuery("SELECT * FROM Products");
            while(result.next()){
                var product = new Product();
                product.setId(result.getInt("id"));
                product.setName(result.getString("name"));
                product.setDescription(result.getString("description"));
                product.setPrice(result.getDouble("price"));
                product.setQuantity(result.getInt("quantity"));
                products.add(product);
            }

            result.close();
            statement.close();
            connection.close();
            return ResponseEntity.ok(products);

        }
        catch(Exception ex){
System.out.println(ex);
        }

        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        //return ResponseEntity.ok(products);
    }
    @GetMapping("/get-by-id/{id}")
    public ResponseEntity GetById(@PathVariable int id){


        try{

            var product = productRepository.getProductById(id);
            if(product == null){
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
            }
            return ResponseEntity.ok(product);

        }
        catch(Exception ex){
            System.out.println(ex);
        }

        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

    }
    @PostMapping("/add")
    public ResponseEntity AddProduct(@RequestBody Product product){
        Connection connection = null;
        Statement statement = null;
        int id = 0;
        try{
            connection = DbUtils.createConnection();
            statement = connection.createStatement();

             statement.executeUpdate(
                    "insert into products (name, price, description, quantity) " +
                            "values('"+
                            product.getName()+"'," +
                            product.getPrice()+", '"+
                            product.getDescription()+"', " +
                            product.getQuantity()+")");

            ResultSet result = statement.executeQuery("select lastval()");
            if (result.next()) {
               id = result.getInt(1);
            }


            result.close();
            statement.close();
            connection.close();


        }
        catch(Exception ex){
            System.out.println(ex);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return GetById(id);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity DeleteProduct(@PathVariable int id){
        Connection connection = null;
        Statement statement = null;
        try{
            connection = DbUtils.createConnection();
            statement = connection.createStatement();

            statement.executeUpdate("DELETE from products where id  = "+id);

            statement.close();
            connection.close();


        }
        catch(Exception ex){
            System.out.println(ex);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity UpdateProduct(@PathVariable int id, @RequestBody Product product){
        Connection connection = null;
        Statement statement = null;
        try{
            connection = DbUtils.createConnection();
            statement = connection.createStatement();

            statement.executeUpdate(
                    "UPDATE products SET " +
                            "name = '"+product.getName()+"'," +
                            "price = "+product.getPrice()+"," +
                            "description = '"+product.getDescription()+"', " +
                            "quantity = "+product.getQuantity());

            statement.close();
            connection.close();


        }
        catch(Exception ex){
            System.out.println(ex);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return GetById(id);
    }
}
