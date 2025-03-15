package com.ExtraShop.Shop.controllers;

import com.ExtraShop.Shop.Services.JwtTokenService;
import com.ExtraShop.Shop.utils.DbUtils;
import org.apache.el.parser.Token;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.token.TokenService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ControllerBase {
    protected interface Operation {
        ResponseEntity execute(Connection connection) throws Exception;
    }

    protected ResponseEntity Handler(Operation operation){
        try {
            Connection connection = null;
            try {
                connection = DbUtils.createConnection();

                var result = operation.execute(connection);

                connection.commit();
                return result;
            } catch (Exception ex) {
                if (connection != null)
                    connection.rollback();
                System.out.println(ex);
                return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
            } finally {
                connection.close();
            }
        }
        catch (Exception ex){
            System.out.println(ex);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    protected boolean Authorization(JwtTokenService tokenService, String token) {
        try {
            if (!tokenService.isTokenValid(token)) {
                return false;
            }
        } catch (Exception ex) {
            return false;
        }
        return true;
    }
}
