package com.ecommerce.api.controllers;


import com.ecommerce.api.dto.PaymentDTO;
import com.ecommerce.api.services.PaymentService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/{id}")
    public ResponseEntity<PaymentDTO> findById(@PathVariable Long id) {
        PaymentDTO dto = paymentService.findById(id);
        return ResponseEntity.ok(dto);
    }
    @GetMapping
    public ResponseEntity<PaymentDTO> getAllPayments() {
        PaymentDTO dto = paymentService.getAllPayments();
        return ResponseEntity.ok(dto);
    }
    @PostMapping
    public ResponseEntity<PaymentDTO> createPayment(@RequestBody PaymentDTO paymentDTO) {
        PaymentDTO dto = paymentService.createPayment(paymentDTO);
        return ResponseEntity.ok(dto);
    }
    @PutMapping("/{id}")
    public ResponseEntity<PaymentDTO> updatePayment(@PathVariable Long id, @RequestBody PaymentDTO paymentDTO) {
        PaymentDTO dto = paymentService.updatePayment(id, paymentDTO);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayment(@PathVariable Long id) {
        PaymentDTO dto = paymentService.deletePayment(id);
        return ResponseEntity.noContent().build();
    }




