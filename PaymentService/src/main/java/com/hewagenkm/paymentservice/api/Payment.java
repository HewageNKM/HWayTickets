package com.hewagenkm.paymentservice.api;

import com.hewagenkm.paymentservice.dto.PaymentDTO;
import com.hewagenkm.paymentservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/payments")
@RequiredArgsConstructor
public class Payment {
    private final Logger logger = LoggerFactory.getLogger(Payment.class);
    private final PaymentService paymentService;

    @PostMapping
    public void addPayment(@Validated @RequestBody PaymentDTO paymentDTO) {
        logger.info("Creating Payment");
        paymentService.addPayment(paymentDTO);
    }

    @GetMapping("/{id}")
    public PaymentDTO getAPayment(@PathVariable Integer id) {
        logger.info("Reviving a Payment");
        return paymentService.getAPayment(id);
    }
}
