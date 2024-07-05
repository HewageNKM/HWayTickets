package com.hewagenkm.ticketservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50)
    private String entranceTerminal;

    @Column(length = 50)
    private String exitTerminal;

    @Column(length = 10)
    private String distance;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(length = 10)
    private String averageSpeed;

    private LocalDateTime dateTime;

    private Integer vehicleId;

}
