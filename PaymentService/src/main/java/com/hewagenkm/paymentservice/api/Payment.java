package com.hewagenkm.paymentservice.api;

import com.hewagenkm.paymentservice.dto.PaymentDTO;
import com.hewagenkm.paymentservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/payments")
@RequiredArgsConstructor
public class Payment {
    private final PaymentService paymentService;

    @PostMapping
    public void createPayment(@Validated @RequestBody PaymentDTO paymentDTO) {
        paymentService.createPayment(paymentDTO);
    }
}
