package com.hewagenkm.paymentservice.service;

import com.hewagenkm.paymentservice.dto.PaymentDTO;

public interface PaymentService {
    void addPayment(PaymentDTO dto);

    PaymentDTO getAPayment(Integer id);
}
