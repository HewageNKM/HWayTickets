package com.hewagenkm.paymentservice.service;


import com.hewagenkm.paymentservice.dto.PaymentDTO;
import com.hewagenkm.paymentservice.entity.Payment;
import com.hewagenkm.paymentservice.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;
    private final Logger logger = LoggerFactory.getLogger(PaymentServiceImpl.class);

    @Override
    public void createPayment(PaymentDTO paymentDTO) {
        logger.info("Payment created");

        Payment payment = Payment.builder()
                .amount(paymentDTO.getAmount())
                .description(paymentDTO.getDescription())
                .amount(paymentDTO.getAmount())
                .status(paymentDTO.getStatus())
                .build();

        paymentRepository.save(payment);
    }

    @Override
    public void updatePayment(PaymentDTO paymentDTO, Integer id) {
        logger.info("Payment updated");

        Payment payment = paymentRepository.findById(id).orElseThrow(() -> new RuntimeException("Payment not found"));
        payment.setStatus(paymentDTO.getStatus());
    }

    @Override
    public PaymentDTO getPayment(Integer id) {
        logger.info("Payment retrieved");

        Payment payment = paymentRepository.findById(id).orElseThrow(() -> new RuntimeException("Payment not found"));

        return PaymentDTO.builder()
                .id(payment.getId())
                .amount(payment.getAmount())
                .description(payment.getDescription())
                .status(payment.getStatus())
                .build();
    }


}
