package com.ExtraShop.Shop.controllers;

import com.ExtraShop.Shop.data.repositories.PaymentMethodRepositoryReliz;
import com.ExtraShop.Shop.models.PaymentMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/payments")
//@CrossOrigin(origins = "http://localhost:4200")
public class PaymentMethodController extends ControllerBase {

    private final PaymentMethodRepositoryReliz repository;

    public PaymentMethodController(PaymentMethodRepositoryReliz repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity getAllPaymentMethods() {
        return Handler(connection -> ResponseEntity.ok(repository.getAllMethod(connection)));

    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentMethod> getPaymentMethodById(@PathVariable int id) {
        return Handler(connection -> ResponseEntity.ok (repository.getById(id,connection)));


    }

    @PostMapping
    public ResponseEntity<PaymentMethod> create(@RequestBody PaymentMethod paymentMethod) {
        return Handler(connection -> ResponseEntity.ok(repository.create(paymentMethod.getName(), connection)));

    }
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable int id, @RequestBody PaymentMethod paymentMethod) {

        return Handler(connection ->{
            repository.update(id, paymentMethod.getName(), connection);
            return new ResponseEntity<>(HttpStatus.OK);
        } );

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        return Handler(connection -> {

            repository.delete(id, connection);
            return new ResponseEntity<>(HttpStatus.OK);


        });
    }
}
