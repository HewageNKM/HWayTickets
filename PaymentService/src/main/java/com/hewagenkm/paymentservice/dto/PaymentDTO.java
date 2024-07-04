package com.hewagenkm.paymentservice.dto;

import com.hewagenkm.paymentservice.entity.Status;
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
    @NotEmpty
    @Length(min = 3, max = 100)
    private String description;

    @NotNull
    @NotEmpty
    @Length(min = 3, max = 100)
    private Double amount;

    @NotNull
    @NotEmpty
    @Enumerated(value = EnumType.STRING)
    private Status status;
}
