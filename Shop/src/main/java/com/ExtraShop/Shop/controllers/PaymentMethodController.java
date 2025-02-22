package com.ExtraShop.Shop.controllers;

import PaymentRepository.PaymentMethodRepositoryReliz;
import com.ExtraShop.Shop.models.PaymentMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/payments")
public class PaymentMethodController {

    private final PaymentMethodRepositoryReliz repository;

    public PaymentMethodController(PaymentMethodRepositoryReliz repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity getAllPaymentMethods() {
        try{
            return ResponseEntity.ok(repository.getAllMethod());
        } catch (Exception ex) {
            System.out.println(ex);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentMethod> getPaymentMethodById(@PathVariable int id) {
       try {
           PaymentMethod paymentMethod = repository.getById(id);
           return ResponseEntity.ok(paymentMethod);
       } catch (Exception ex) {
           System.out.println(ex);
           return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
       }

    }

    @PostMapping
    public ResponseEntity<PaymentMethod> create(@RequestBody PaymentMethod paymentMethod) {
        try {
          var result =  repository.create(paymentMethod.getName());
            return ResponseEntity.ok(result);
        } catch (Exception ex) {
            System.out.println(ex);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
