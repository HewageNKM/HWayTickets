package com.hewagenkm.vehicleservice.repository;

import com.hewagenkm.vehicleservice.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer>{
    Optional<Vehicle> findByLicensePlate(String license);
}
