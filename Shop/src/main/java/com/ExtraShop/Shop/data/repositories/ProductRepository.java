package com.ExtraShop.Shop.data.repositories;

import com.ExtraShop.Shop.models.Product;
import com.ExtraShop.Shop.utils.DbUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

@Service
public class ProductRepository{
    private final DbContextService dbContextService;

    public ProductRepository(DbContextService dbContextService){
        this.dbContextService = dbContextService;
    }
    public Product getProductById(int id)throws Exception{
            var statement = dbContextService.getConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM Products WHERE id = "+id);
            Product product = null;
            while(result.next()){
                product = new Product();
                product.setId(result.getInt("id"));
                product.setName(result.getString("name"));
                product.setDescription(result.getString("description"));
                product.setPrice(result.getDouble("price"));
                product.setQuantity(result.getInt("quantity"));
                break;
            }
            statement.close();

           return product;
    }
}
