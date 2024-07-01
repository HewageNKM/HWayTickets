package com.hewagenkm.vehicleservice.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "owners")
public class Owner {
    @Id
    @Column(length = 10)
    private String id;
    @Column(length = 13, unique = true)
    private String iDNumber;
    @Column(length = 100)
    private String fullName;
    @Column(length = 100)
    private String email;
    @Column(length = 13)
    private String phone;
    @Column(length = 100)
    private String address;

    // one owner can have multiple vehicles
    @OneToMany(mappedBy = "owner")
    private List<Vehicle> vehicles;
}
