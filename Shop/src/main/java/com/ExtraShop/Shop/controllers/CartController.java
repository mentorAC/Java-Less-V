package com.ExtraShop.Shop.controllers;

import com.ExtraShop.Shop.Services.JwtTokenService;
import com.ExtraShop.Shop.data.repositories.CartRepository;
import com.ExtraShop.Shop.data.repositories.DbContextService;
import com.ExtraShop.Shop.models.Product;
import com.ExtraShop.Shop.utils.Constants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
@CrossOrigin(origins = "http://localhost:4200")
public class CartController {
    private final JwtTokenService tokenService;
    private final CartRepository cartRepository;
    private final DbContextService dbContextService;

    public CartController(JwtTokenService tokenService, CartRepository cartRepository, DbContextService dbContextService)throws Exception {
        this.tokenService = tokenService;
        this.cartRepository = cartRepository;
        this.dbContextService = dbContextService;
    }

    @PostMapping("add-to-cart/{productId}")
    public ResponseEntity AddToCart(@PathVariable int productId, @RequestHeader(Constants.AUTH_HEADER) String header) {
        try {
            var token = header.split(" ")[1];
            if (!Authorization(token)) return new ResponseEntity(HttpStatus.UNAUTHORIZED);

            var userId = tokenService.extractUserId(token);
            dbContextService.init();

            if (cartRepository.isProductExists(userId, productId)) {
                return ResponseEntity.ok("\"Product already in the cart!\"");
            }

            cartRepository.add(userId, productId);
            return ResponseEntity.ok("");
        } catch (Exception ex) {
            System.out.println(ex);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        finally {
            try{
            dbContextService.dispose();
            }catch (Exception ex){

            }

        }
    }

    @DeleteMapping("delete-item/{productId}")
    public ResponseEntity delete (@PathVariable int productId, @RequestHeader(Constants.AUTH_HEADER) String header ){
        try{
            var token = header.split(" ")[1];
            if (!Authorization(token)) return new ResponseEntity(HttpStatus.UNAUTHORIZED);
            var userId = tokenService.extractUserId(token);
            dbContextService.init();
            if(!cartRepository.isProductExists(userId,productId)){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            cartRepository.delete(userId, productId);
        }catch (Exception ex){
            System.out.println(ex);
        }finally {
            try {
                dbContextService.dispose();
            } catch (Exception ex) {
            }
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("dec-item/{productId}")
    public ResponseEntity decreaseQuantity(@PathVariable int productId, @RequestHeader(Constants.AUTH_HEADER) String header) {
        try {
            dbContextService.init();
            var token = header.split(" ")[1];
            if (!Authorization(token)) return new ResponseEntity(HttpStatus.UNAUTHORIZED);

            var userId = tokenService.extractUserId(token);
            if (!cartRepository.isProductExists(userId, productId)) {
                return new ResponseEntity(" Product is not in a cart", HttpStatus.BAD_REQUEST);

            }
            var cartItem = cartRepository.GetCartItem(userId, productId);
            if (cartItem.getQuantity() <= 1) {
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
            }
            cartRepository.decitem(userId, productId);

            return ResponseEntity.ok("");
        }catch (Exception ex) {
            System.out.println(ex);

        } finally {
            try {
                dbContextService.dispose();
            } catch (Exception ex) {
            }
        }
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);

    }




    @PutMapping("inc-item/{productId}")
    public ResponseEntity increaseQuantity(@PathVariable int productId, @RequestHeader(Constants.AUTH_HEADER) String header) {
        try {
            dbContextService.init();
            var token = header.split(" ")[1];
            if (!Authorization(token)) return new ResponseEntity(HttpStatus.UNAUTHORIZED);

            var userId = tokenService.extractUserId(token);
            if (cartRepository.isProductExists(userId, productId)) {
              cartRepository.incitem( userId, productId);
            } else {
                return new ResponseEntity(" Product is not in a cart", HttpStatus.BAD_REQUEST);
            }
            return ResponseEntity.ok("");
        } catch (Exception ex) {
            System.out.println(ex);

        } finally {
            try {
                dbContextService.dispose();
            } catch (Exception ex) {
            }
        }
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);

    }


    @GetMapping("get-item")
    public ResponseEntity GetCart(@RequestHeader(Constants.AUTH_HEADER) String header) {
        try {
            dbContextService.init();
            var token = header.split(" ")[1];
            if (!Authorization(token)) return new ResponseEntity(HttpStatus.UNAUTHORIZED);

            var userId = tokenService.extractUserId(token);
            return  ResponseEntity.ok(cartRepository.GetCart(userId));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        finally {
            try{
                dbContextService.dispose();
            }catch (Exception ex){}
        }
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private boolean Authorization(String token) {
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
