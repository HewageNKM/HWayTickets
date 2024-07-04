package com.hewagenkm.paymentservice.service;

import com.hewagenkm.paymentservice.dto.PaymentDTO;

public interface PaymentService {
    void createPayment(PaymentDTO paymentDTO);
    void updatePayment(PaymentDTO paymentDTO, Integer id);
    PaymentDTO getPayment(Integer id);
}
