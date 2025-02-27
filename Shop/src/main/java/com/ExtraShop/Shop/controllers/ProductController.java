package com.ExtraShop.Shop.controllers;

//import com.ExtraShop.Shop.data.entities.Product;
//import com.ExtraShop.Shop.data.repositories.ProductRepository;
//import com.ExtraShop.Shop.models.Product;
import com.ExtraShop.Shop.data.repositories.DbContextService;
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
    private final DbContextService dbContext;

    //GET
    //POST
    //PUT
    //DELETE
ProductController(ProductRepository productRepository, DbContextService dbContext){
    this.productRepository = productRepository;

    this.dbContext = dbContext;
    dbContext.init();
}

    @GetMapping("/get-all-product")
    public ResponseEntity GetAllProduct(){

       try {
           var products = this.productRepository.getAllProducts();
           dbContext.dispose();
           return ResponseEntity.ok(products);
       } catch (Exception ex) {
           dbContext.rollback();
           System.out.println(ex);
           return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
       }
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
        try{
            var result = this.productRepository.addProduct(product);
            return GetById(result);
        }catch(Exception ex){
            System.out.println(ex);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity DeleteProduct(@PathVariable int id){
        try{
            this.productRepository.deleteProduct(id);
        }
        catch(Exception ex){
            System.out.println(ex);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity UpdateProduct(@PathVariable int id, @RequestBody Product product){
        try{
            this.productRepository.updateProduct(id,product);

        }
        catch(Exception ex){
            System.out.println(ex);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return GetById(id);
    }
}
