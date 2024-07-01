package com.hewagenkm.vehicleservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vehicles")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 10)
    private String id;
    @Column(length = 10, unique = true)
    private String licensePlate;
    @Column(length = 2)
    private String classType;

    // one vehicle can only have one owner
    @OneToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Owner owner;
}
