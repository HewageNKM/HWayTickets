package com.hewagenkm.ticketservice.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50)
    private String entrance;

    @Column(length = 50)
    private String exit;

    @Column(length = 4)
    private Double averageSpeed;

    @Column(length = 20)
    private Double totalCost;

    private LocalDateTime dateTime;

    @Enumerated(value = EnumType.STRING)
    private Status status;

    @OneToOne
    @JoinColumn(referencedColumnName = "id")
    private Vehicle vehicle;
}
