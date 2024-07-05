package com.hewagenkm.paymentservice.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentDTO {
    private Integer id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private PaymentMethod method;

    @NotNull
    private Double amount;

    @NotNull
    private Integer ticketId;
}
