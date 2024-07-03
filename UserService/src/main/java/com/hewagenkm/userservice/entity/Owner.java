package com.hewagenkm.userservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 13, unique = true)
    private String nic;
    @Column(length = 100)
    private String fullName;
    @Column(length = 100)
    private String email;
    @Column(length = 13)
    private String phone;
    @Column(length = 100)
    private String address;

    @OneToMany(mappedBy = "owner",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}, fetch = FetchType.EAGER)
    private List<Vehicle> vehicles;
}
