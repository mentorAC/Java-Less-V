package com.ExtraShop.Shop.data.repositories;

import com.ExtraShop.Shop.models.CartItem;
import com.ExtraShop.Shop.utils.DbUtils;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;


@Service
public class CartRepository {

    private final ProductRepository productRepository;

    CartRepository(ProductRepository productRepository){
        this.productRepository = productRepository;

    }


    public void add(int userId, int productId,Connection connection)throws Exception{
        var statement = connection.createStatement();
        statement.executeUpdate(
                "INSERT INTO \"cartitem\" (userId, productId)" +
                        "VALUES ("+userId+", "+productId+")");
        statement.close();
    }
    public void delete(int userId, int productId,Connection connection) throws Exception{
        var statement = connection.createStatement();
        statement.executeUpdate(
                "DELETE FROM  \"cartitem\" WHERE userId = " +userId+" AND productId="+productId
        );
        statement.close();
    }

    public boolean isProductExists(int userId, int productId, Connection connection)throws Exception{
        var statement = connection.createStatement();
        ResultSet result =statement.executeQuery(
                "select count(*) as is_exists from cartitem " +
                "where userId = "+userId+" and productId = "+productId);
        result.next();
        var response = result.getInt("is_exists") > 0;
        result.close();
        statement.close();
        return response;
    }
    public void incitem(int userId, int productId, Connection connection) throws Exception{
        var statement = connection.createStatement();
        statement.executeUpdate(
        "UPDATE cartitem set quantity = quantity+1 " +
                "where userId = "+userId+" and productId = "+productId);
        statement.close();

    }
    public void decitem(int userId, int productId, Connection connection) throws Exception{
        var statement = connection.createStatement();
        statement.executeUpdate(
                "UPDATE cartitem set quantity = quantity-1 " +
                        "where userId = "+userId+" and productId = "+productId);
        statement.close();

    }
    public CartItem GetCartItem(int userId, int productId,Connection connection)throws Exception{
        var statement = connection.createStatement();
       var result = statement.executeQuery(
                "select * from cartitem where userId = "+userId+" and productId = "+productId
        );
       result.next();
       CartItem cartItem = new CartItem();
       cartItem.setQuantity(result.getInt("quantity"));
       cartItem.setProductId(result.getInt("productId"));
       result.close();
        statement.close();
        return cartItem;

    }

    public LinkedList<CartItem> GetCart(int userId,Connection connection)throws Exception{
        var statement = connection.createStatement();

        ResultSet result =statement.executeQuery(
                "select *  from cartitem " + "where userId = "+userId);
        LinkedList<CartItem> list = new LinkedList<>();
        while(result.next()){
            CartItem cartItem = new CartItem();
            cartItem.setQuantity(result.getInt("quantity"));
            cartItem.setProductId(result.getInt("productId"));
            cartItem.setProduct(productRepository.getProductById(cartItem.getProductId(),connection));
            list.add(cartItem);
        }
        result.close();
        statement.close();

        return list;
    };
}
