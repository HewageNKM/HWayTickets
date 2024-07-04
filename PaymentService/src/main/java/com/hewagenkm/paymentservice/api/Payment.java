package com.hewagenkm.paymentservice.api;

import com.hewagenkm.paymentservice.dto.PaymentDTO;
import com.hewagenkm.paymentservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/payments")
@RequiredArgsConstructor
public class Payment {
    private final PaymentService paymentService;

    @PutMapping("/{id}")
    public void updatePayment(@Validated @RequestBody PaymentDTO paymentDTO, @PathVariable Integer id) {
        paymentService.updatePayment(paymentDTO, id);
    }
}
