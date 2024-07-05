package com.hewagenkm.paymentservice.service;


import com.hewagenkm.paymentservice.dto.PaymentDTO;
import com.hewagenkm.paymentservice.dto.Status;
import com.hewagenkm.paymentservice.dto.TicketDTO;
import com.hewagenkm.paymentservice.entity.Payment;
import com.hewagenkm.paymentservice.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Transactional
public class PaymentServiceImpl implements PaymentService {
    private final RestTemplate restTemplate;
    private final PaymentRepository paymentRepository;
    private final Logger logger = LoggerFactory.getLogger(PaymentServiceImpl.class);

    @Override
    public void addPayment(PaymentDTO dto) {
        logger.info("Adding payment for ticket: {}", dto.getTicketId());
        paymentRepository.save(
                Payment
                        .builder()
                        .amount(dto.getAmount())
                        .paymentMethod(dto.getMethod())
                        .dateTime(LocalDateTime.now())
                        .ticketId(dto.getTicketId())
                        .build()
        );

        TicketDTO ticketDTO = TicketDTO.builder().status(Status.Paid).build();
        restTemplate.put("http://ticket-service/api/v1/tickets/status/" + dto.getTicketId(), ticketDTO);

        logger.info("Ticket status updated to paid for ticket: {}", dto.getTicketId());
    }

    @Override
    public PaymentDTO getAPayment(Integer id) {
        Payment payment = paymentRepository.findById(id).orElseThrow(() -> new RuntimeException("Payment Not Found"));
        logger.info("Reviving a Payment");
        return  PaymentDTO
                .builder()
                .id(payment.getId())
                .method(payment.getPaymentMethod())
                .amount(payment.getAmount())
                .ticketId(payment.getTicketId())
                .build();

    }
}
