package com.hewagenkm.ticketservice.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TicketDTO {

    private Integer id;

    @NotEmpty
    @NotNull
    @Length(min = 2, max = 50)
    private String entrance;

    @NotEmpty
    @NotNull
    @Length(min = 2, max = 10)
    private String exit;

    @NotEmpty
    @NotNull
    @Length(min = 2, max = 10)
    private String licencePlate;

    @NotEmpty
    @NotNull
    @Length(min = 2, max = 10)
    private Double averageSpeed;

    @NotEmpty
    @NotNull
    @Length(min = 2, max = 10)
    private Double totalCost;
}
