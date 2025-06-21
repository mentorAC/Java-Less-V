package com.ExtraShop.Shop.data.repositories;

import com.ExtraShop.Shop.models.Product;
import com.ExtraShop.Shop.utils.DbUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;



@Service
public class ProductRepository {
    // private final DbContextService dbContextService;

//    public ProductRepository(DbContextService dbContextService) {
//        this.dbContextService = dbContextService;
//    }

    public List<Product> getAllProducts(Connection connection) throws Exception {
        List<Product> products = new LinkedList<>();
        Statement statement = connection.createStatement();
        ;
        ResultSet result = statement.executeQuery("SELECT * FROM Products");

        while (result.next()) {
            Product product = new Product();
            product.setId(result.getInt("id"));
            product.setName(result.getString("name"));
            product.setDescription(result.getString("description"));
            product.setPrice(result.getDouble("price"));
            product.setQuantity(result.getInt("quantity"));
            product.setPhotoURL(result.getString( "photoURL"));
            products.add(product);
        }
        result.close();
        statement.close();

        return products;
    }

    public Product getProductById(int id, Connection connection) throws Exception {
        Product product = null;
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM Products WHERE id = " + id);

        if (result.next()) {
            product = new Product();
            product.setId(result.getInt("id"));
            product.setName(result.getString("name"));
            product.setDescription(result.getString("description"));
            product.setPrice(result.getDouble("price"));
            product.setQuantity(result.getInt("quantity"));
        }

        return product;
    }

    public int addProduct(Product product, Connection connection) throws Exception {
        int id = 0;
        Statement statement = connection.createStatement();

        statement.executeUpdate(
                "INSERT INTO products (name, price, description, quantity) VALUES ('" +
                        product.getName() + "', " +
                        product.getPrice() + ", '" +
                        product.getDescription() + "', " +
                        product.getQuantity() + ")", Statement.RETURN_GENERATED_KEYS);

        ResultSet result = statement.getGeneratedKeys();
        if (result.next()) {
            id = result.getInt("id");
        }
        result.close();
        statement.close();

        return id;
    }

    public void deleteProduct(int id, Connection connection) throws Exception {
        Statement statement = connection.createStatement();
        statement.executeUpdate("DELETE FROM products WHERE id = " + id);
        statement.close();
    }

    public void updateProduct(int id, Product product, Connection connection) throws Exception {
        Statement statement = connection.createStatement();

        statement.executeUpdate(
                "UPDATE products SET " +
                        "name = '" + product.getName() + "', " +
                        "price = " + product.getPrice() + ", " +
                        "description = '" + product.getDescription() + "', " +
                        "quantity = " + product.getQuantity() +
                        " WHERE id = " + id);

        statement.close();
    }

}
