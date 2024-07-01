package com.hewagenkm.vehicleservice.service;

import com.hewagenkm.vehicleservice.dto.OwnerDTO;
import com.hewagenkm.vehicleservice.dto.VehicleDTO;
import com.hewagenkm.vehicleservice.entity.Owner;
import com.hewagenkm.vehicleservice.entity.Vehicle;
import com.hewagenkm.vehicleservice.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService {

    private final RestTemplate restTemplate;
    private final VehicleRepository vehicleRepository;
    private final Logger logger = LoggerFactory.getLogger(VehicleServiceImpl.class);


    @Override
    public List<VehicleDTO> getVehicles(Integer page, Integer size, String sortBy, String sortOrder, String filter) {
        logger.info("Getting all vehicles");
        return vehicleRepository.findAll().stream().map(vehicle -> VehicleDTO.builder()
                .licensePlate(vehicle.getLicensePlate())
                .classType(vehicle.getClassType())
                .owner(
                        OwnerDTO
                                .builder()
                                .id(vehicle.getOwner().getId())
                                .fullName(vehicle.getOwner().getFullName())
                                .address(vehicle.getOwner().getAddress())
                                .email(vehicle.getOwner().getEmail())
                                .phone(vehicle.getOwner().getPhone())
                                .iDNumber(vehicle.getOwner().getIDNumber())
                                .build()
                )
                .build()).toList();
    }

    @Override
    public void createVehicle(VehicleDTO vehicleDTO) {
        ResponseEntity<OwnerDTO> forEntity = restTemplate.getForEntity("http://localhost:8080/api/v1/users?type=owner" + vehicleDTO.getOwner().getId(), OwnerDTO.class);
        OwnerDTO ownerDTO = forEntity.getBody();
        if (ownerDTO == null) {
            throw new RuntimeException("Owner not found");
        }
        Vehicle vehicle = Vehicle.builder()
                .licensePlate(vehicleDTO.getLicensePlate())
                .classType(vehicleDTO.getClassType())
                .owner(
                        Owner
                                .builder()
                                .fullName(ownerDTO.getFullName())
                                .address(ownerDTO.getAddress())
                                .email(ownerDTO.getEmail())
                                .phone(ownerDTO.getPhone())
                                .iDNumber(ownerDTO.getIDNumber())
                                .build()
                )
                .build();
        vehicleRepository.save(vehicle);
        logger.info("Vehicle created");
    }

    @Override
    public void updateVehicle(VehicleDTO vehicleDTO, String id) {
        Vehicle vehicle = vehicleRepository.findById(id).orElseThrow(() -> new RuntimeException("Vehicle not found"));
        ResponseEntity<OwnerDTO> forEntity = restTemplate.getForEntity("http://localhost:8080/api/v1/users?type=owner" + vehicleDTO.getOwner().getId(), OwnerDTO.class);
        OwnerDTO ownerDTO = forEntity.getBody();

        if (ownerDTO == null) {
            throw new RuntimeException("Owner not found");
        }
        vehicle.setLicensePlate(vehicleDTO.getLicensePlate());
        vehicle.setClassType(vehicleDTO.getClassType());
        vehicle.setOwner(
                Owner
                        .builder()
                        .fullName(ownerDTO.getFullName())
                        .address(ownerDTO.getAddress())
                        .email(ownerDTO.getEmail())
                        .phone(ownerDTO.getPhone())
                        .iDNumber(ownerDTO.getIDNumber())
                        .build()
        );
        vehicleRepository.save(vehicle);
        logger.info("Vehicle updated");
    }


    @Override
    public VehicleDTO get(String id) {
        Vehicle vehicle = vehicleRepository.findById(id).orElseThrow(() -> new RuntimeException("Vehicle not found"));
        logger.info("Getting vehicle with id: {}", id);
        return VehicleDTO.builder()
                .licensePlate(vehicle.getLicensePlate())
                .classType(vehicle.getClassType())
                .owner(
                        OwnerDTO
                                .builder()
                                .id(vehicle.getOwner().getId())
                                .fullName(vehicle.getOwner().getFullName())
                                .address(vehicle.getOwner().getAddress())
                                .email(vehicle.getOwner().getEmail())
                                .phone(vehicle.getOwner().getPhone())
                                .iDNumber(vehicle.getOwner().getIDNumber())
                                .build()
                )
                .build();
    }
}
