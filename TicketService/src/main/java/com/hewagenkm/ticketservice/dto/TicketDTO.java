package com.hewagenkm.ticketservice.dto;

import com.hewagenkm.ticketservice.entity.Status;
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
    private String exit;

    @Enumerated(value = EnumType.STRING)
    private Status status;

    @NotEmpty
    @NotNull
    @Length(min = 2, max = 10)
    private String licencePlate;
    private Double averageSpeed;
    private Double totalCost;
}
