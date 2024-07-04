package com.hewagenkm.ticketservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Payment {
    @Id
    private Integer id;
    private String description;
    private Double amount;
    @Enumerated(value = EnumType.STRING)
    private Status status;
}
