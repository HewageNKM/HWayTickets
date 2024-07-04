package com.hewagenkm.ticketservice.dto;

import com.hewagenkm.ticketservice.entity.Payment;
import com.hewagenkm.ticketservice.entity.Vehicle;
import jakarta.persistence.*;
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


    private String exitTerminal;
    private String distance;
    private Double averageSpeed;
    private LocalDateTime dateTime;

    @NotNull
    @NotEmpty
    private Vehicle vehicle;

    @NotNull
    @NotEmpty
    @Length(min = 3, max = 50)
    private Payment payment;

}
