package com.hewagenkm.ticketservice.dto;

import com.hewagenkm.ticketservice.entity.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TicketDTO {
    private Integer id;

    @NotNull
    private String entranceTerminal;

    @NotNull
    private String exitTerminal;

    @NotNull
    private String distance;

    @NotNull
    private Status status;

    @NotNull
    private String averageSpeed;


    private LocalDateTime dateTime;

    @NotNull
    private Integer vehicleId;

}
