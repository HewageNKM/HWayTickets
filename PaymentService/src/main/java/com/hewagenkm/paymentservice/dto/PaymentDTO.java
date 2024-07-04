package com.hewagenkm.paymentservice.dto;

import com.hewagenkm.paymentservice.entity.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentDTO {
    private Integer id;
    private String description;
    private Double amount;
    private Status status;
}
