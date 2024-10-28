package com.ExtraShop.Shop.controllers;

//import com.ExtraShop.Shop.data.entities.User;
//import com.ExtraShop.Shop.data.repositories.UserRepository;
import com.ExtraShop.Shop.models.LoginRequest;
import com.ExtraShop.Shop.models.LoginResponse;
import com.ExtraShop.Shop.models.RegisterRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.Base64;

@RestController
@RequestMapping("/account")
@CrossOrigin(origins = "http://localhost:4200")
public class AccountController {
    //private final UserRepository userRepository;
//    public AccountController(UserRepository userRepository){
//        this.userRepository = userRepository;
//    }
    @PostMapping("/login")

    public ResponseEntity login(@RequestBody LoginRequest account){
//       var users = userRepository.getAll();
//        for (var user:users) {
//            if( user.getUsername() == account.getUsername() && user.getPassword() == account.getPassword() ) {
//                return ResponseEntity.ok(new LoginResponse());
//            }
//        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }
    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterRequest register){
        try {

        }catch (Exception ex){
            System.out.println(ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
