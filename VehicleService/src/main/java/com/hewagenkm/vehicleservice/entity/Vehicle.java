package com.hewagenkm.vehicleservice.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "vehicles")
public class Vehicle {
    @Id
    @Column(length = 10)
    private String id;
    @Column(length = 10, unique = true)
    private String licensePlate;
    @Column(length = 2)
    private String classType;

    // one vehicle can only have one owner
    @OneToOne
    @JoinColumn(name = "id")
    private Owner owner;
}
