package com.ExtraShop.Shop.controllers;

import com.ExtraShop.Shop.Services.JwtTokenService;
import com.ExtraShop.Shop.data.repositories.CartRepository;
import com.ExtraShop.Shop.utils.Constants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
@CrossOrigin(origins = "http://localhost:4200")
public class CartController extends ControllerBase {
    private final JwtTokenService tokenService;
    private final CartRepository cartRepository;

    public CartController(JwtTokenService tokenService, CartRepository cartRepository)throws Exception {
        this.tokenService = tokenService;
        this.cartRepository = cartRepository;
    }

    @PostMapping("add-to-cart/{productId}")
    public ResponseEntity AddToCart(@PathVariable int productId, @RequestHeader(Constants.AUTH_HEADER) String header) {

        return Handler(connection ->{
            var token = header.split(" ")[1];
            if (!Authorization(tokenService,token)) return new ResponseEntity(HttpStatus.UNAUTHORIZED);
            var userId = tokenService.extractUserId(token);
            cartRepository.add(userId,productId,connection);
            return new ResponseEntity<>(HttpStatus.OK);

        });

    }

    @DeleteMapping("delete-item/{productId}")
    public ResponseEntity delete (@PathVariable int productId, @RequestHeader(Constants.AUTH_HEADER) String header ) {
        return Handler(connection -> {
            var token = header.split(" ")[1];
            if (!Authorization(tokenService, token)) return new ResponseEntity(HttpStatus.UNAUTHORIZED);
            var userId = tokenService.extractUserId(token);
            if (!cartRepository.isProductExists(userId, productId,connection)) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            cartRepository.delete(userId, productId, connection);
            return new ResponseEntity<>(HttpStatus.OK);

        });
    }

    @PutMapping("dec-item/{productId}")
    public ResponseEntity decreaseQuantity(@PathVariable int productId, @RequestHeader(Constants.AUTH_HEADER) String header) {
        return Handler(connection -> {
            var token = header.split(" ")[1];
            if (!Authorization(tokenService,token)) return new ResponseEntity(HttpStatus.UNAUTHORIZED);
            var userId = tokenService.extractUserId(token);
            if (!cartRepository.isProductExists(userId, productId, connection)) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            var cartItem = cartRepository.GetCartItem(userId, productId, connection);
            if (cartItem.getQuantity() <= 1) {
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
            }
            cartRepository.decitem(userId, productId, connection);
            return new ResponseEntity<>(HttpStatus.OK);

        });
    }




    @PutMapping("inc-item/{productId}")
    public ResponseEntity increaseQuantity(@PathVariable int productId, @RequestHeader(Constants.AUTH_HEADER) String header) {
        return Handler(connection -> {
            var token = header.split(" ")[1];
            if (!Authorization(tokenService,token)) return new ResponseEntity(HttpStatus.UNAUTHORIZED);
            var userId = tokenService.extractUserId(token);
            if (!cartRepository.isProductExists(userId, productId, connection)) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            cartRepository.incitem(userId, productId, connection);
            return new ResponseEntity<>(HttpStatus.OK);

        });
    }


    @GetMapping("get-item")
    public ResponseEntity GetCart(@RequestHeader(Constants.AUTH_HEADER) String header) {
        return Handler(connection -> {
            var token = header.split(" ")[1];
            if (!Authorization(tokenService, token)) return new ResponseEntity(HttpStatus.UNAUTHORIZED);
            var userId = tokenService.extractUserId(token);
            return ResponseEntity.ok(cartRepository.GetCart(userId, connection));
        });
    }


}
