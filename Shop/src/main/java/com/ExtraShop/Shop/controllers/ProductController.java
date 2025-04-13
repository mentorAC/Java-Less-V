package com.ExtraShop.Shop.controllers;

import com.ExtraShop.Shop.data.repositories.ProductRepository;
import com.ExtraShop.Shop.models.Product;
import com.ExtraShop.Shop.utils.DbUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;

@RestController
@RequestMapping("/product")
public class ProductController extends ControllerBase {
    private final ProductRepository productRepository;
    //private final DbContextService dbContext;

    //GET
    //POST
    //PUT
    //DELETE
ProductController(ProductRepository productRepository /*DbContextService dbContext*/){
    this.productRepository = productRepository;
}

    @GetMapping("/get-all-product")
    public ResponseEntity GetAllProduct() {
       return Handler(connection -> ResponseEntity.ok(productRepository.getAllProducts(connection)));
    }

    @GetMapping("/get-by-id/{id}")
    public ResponseEntity GetById(@PathVariable int id){
        return Handler(connection -> ResponseEntity.ok(productRepository.getProductById(id, connection)));
    }

    @PostMapping("/add")
    public ResponseEntity AddProduct(@RequestBody Product product){
        return  Handler(connection ->{
            var productId = productRepository.addProduct(product, connection);
            connection.commit();
            return GetById(productId);

        });
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity DeleteProduct(@PathVariable int id){

        return Handler(connection ->{
            productRepository.deleteProduct(id, connection);
            return new ResponseEntity<>(HttpStatus.OK);
        });
    }

    @PutMapping("/update/{id}")
    public ResponseEntity UpdateProduct(@PathVariable int id, @RequestBody Product product){

        return Handler(connection ->
        {
            productRepository.updateProduct(id, product, connection);
            var updatedProduct = GetById(id);
            var response = ResponseEntity.ok(updatedProduct);
            return response;
        });
    }
}
