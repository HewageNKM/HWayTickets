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

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TicketDTO {


    private Integer id;

    @NotNull
    @NotEmpty
    @Length(min = 3, max = 50)
    private String entranceTerminal;

    @NotNull
    @NotEmpty
    @Length(min = 3, max = 50)
    private String exitTerminal;

    @NotNull
    @NotEmpty
    @Length(min = 3, max = 50)
    private String distance;

    @Enumerated(EnumType.STRING)
    private Status status;

    @NotNull
    @NotEmpty
    @Length(min = 3, max = 50)
    private Double averageSpeed;

    @NotNull
    @NotEmpty
    private Integer vehicleId;

    private LocalDateTime dateTime;
}
