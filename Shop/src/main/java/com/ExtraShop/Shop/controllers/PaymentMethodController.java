package com.ExtraShop.Shop.controllers;


import com.example.payment.model.PaymentMethod;
import com.example.payment.repository.PaymentMethodRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

        import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/payments")
public class PaymentMethodController {

    private final PaymentMethodRepository repository;

    public PaymentMethodController(PaymentMethodRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<PaymentMethod> getAllPaymentMethods() {
        return repository.getAllPaymentMethods();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentMethod> getPaymentMethodById(@PathVariable Long id) {
        Optional<PaymentMethod> paymentMethod = repository.getPaymentMethodById(id);
        return paymentMethod.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<String> createPaymentMethod(@RequestBody PaymentMethod paymentMethod) {
        repository.createPaymentMethod(paymentMethod);
        return ResponseEntity.ok("Способ оплаты успешно добавлен");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePaymentMethod(@PathVariable Long id, @RequestBody PaymentMethod paymentMethod) {
        repository.updatePaymentMethod(id, paymentMethod);
        return ResponseEntity.ok("Способ оплаты обновлён");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePaymentMethod(@PathVariable Long id) {
        repository.deletePaymentMethod(id);
        return ResponseEntity.ok("Способ оплаты удалён");
    }
}
