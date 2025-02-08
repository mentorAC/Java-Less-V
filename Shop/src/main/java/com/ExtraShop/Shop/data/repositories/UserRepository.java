package com.ExtraShop.Shop.data.repositories;

import com.ExtraShop.Shop.utils.DbUtils;
import com.ExtraShop.Shop.utils.PasswordHandler;
import org.springframework.stereotype.Service;
import com.ExtraShop.Shop.models.User;
import java.sql.Connection;
import java.sql.Statement;

@Service
public class UserRepository {
    public User getByUsername(String username) throws Exception {

        var connection = DbUtils.createConnection();
        var statement = connection.createStatement();

        var result = statement.executeQuery("SELECT * FROM \"User\" WHERE username = '"+username+"'");
        User user = new User();
result.next();
        user.setId(result.getInt("id"));
        user.setUsername(result.getString("username"));
        user.setPhone(result.getString("phone"));
        user.setEmail(result.getString("email"));
        user.setPasswordhash(result.getString("passwordhash"));
        user.setSalt(result.getString("salt"));
        statement.close();
        connection.close();

        return user;
    }

    public void add(String username, String phone, String email, String passwordHash, String salt)throws Exception{
        var connection = DbUtils.createConnection();
        var statement = connection.createStatement();

        statement.executeUpdate(
                "INSERT INTO \"User\" (username, email, phone, passwordhash, salt)" +
                     "VALUES ('"+username+"', '"+email+"', '"+phone+"', '"+passwordHash+"', '"+salt+"')");
        statement.close();
        connection.close();
    }
}
