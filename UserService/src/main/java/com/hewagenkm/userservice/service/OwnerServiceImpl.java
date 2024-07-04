package com.hewagenkm.userservice.service;

import com.hewagenkm.userservice.dto.Owner;
import com.hewagenkm.userservice.dto.VehicleDTO;
import com.hewagenkm.userservice.entity.Vehicle;
import com.hewagenkm.userservice.repository.OwnerRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class OwnerServiceImpl implements OwnerService {

    private final OwnerRepository ownerRepository;
    private final Logger logger = LoggerFactory.getLogger(OwnerServiceImpl.class);

    @Override
    public void addOwner(Owner dto) {
        ownerRepository.save(
                com.hewagenkm.userservice.entity.Owner.builder()
                        .nic(dto.getNic())
                        .fullName(dto.getFullName())
                        .email(dto.getEmail())
                        .phone(dto.getPhone())
                        .address(dto.getAddress())
                        .vehicles(new ArrayList<>())
                        .build()
        );
        logger.info("Owner added");
    }

    @Override
    public List<Owner> getOwners(int page, int size, String filter, String sort) {
        logger.info("Getting all owners");
        return ownerRepository.findAll().stream().map(owner -> Owner.builder()
                .id(owner.getId())
                .nic(owner.getNic())
                .fullName(owner.getFullName())
                .email(owner.getEmail())
                .phone(owner.getPhone())
                .address(owner.getAddress())
                .vehicles(owner.getVehicles().stream().map(vehicle -> VehicleDTO.builder()
                        .id(vehicle.getId())
                        .classType(vehicle.getClassType())
                        .licensePlate(vehicle.getLicensePlate())
                        .build()).toList())
                .build()).toList();
    }

    @Override
    public void updateOwner(java.lang.Integer id, Owner dto) {
        com.hewagenkm.userservice.entity.Owner owner = ownerRepository.findById(id).orElseThrow(() -> new RuntimeException("Owner not found"));
        owner.setNic(dto.getNic());
        owner.setFullName(dto.getFullName());
        owner.setEmail(dto.getEmail());
        owner.setPhone(dto.getPhone());
        owner.setAddress(dto.getAddress());
        owner.setVehicles(dto.getVehicles().stream().map(vehicleDTO -> Vehicle.builder()
                .id(vehicleDTO.getId())
                .classType(vehicleDTO.getClassType())
                .licensePlate(vehicleDTO.getLicensePlate())
                .build()).toList());
        ownerRepository.save(owner);
        logger.info("Owner updated");
    }

    @Override
    public void deleteOwner(java.lang.Integer id) {
        ownerRepository.deleteById(id);
        logger.info("Owner deleted");
    }

    @Override
    public Owner getOwner(java.lang.Integer id) {
        com.hewagenkm.userservice.entity.Owner owner = ownerRepository.findById(id).orElseThrow(() -> new RuntimeException("Owner not found"));
        logger.info("Getting owner with id: {}", id);
        return getOwnerDTO(owner);
    }
    

    private Owner getOwnerDTO(com.hewagenkm.userservice.entity.Owner owner) {
        return Owner.builder()
                .id(owner.getId())
                .nic(owner.getNic())
                .fullName(owner.getFullName())
                .email(owner.getEmail())
                .phone(owner.getPhone())
                .address(owner.getAddress())
                .vehicles(owner.getVehicles().stream().map(vehicle -> VehicleDTO.builder()
                        .id(vehicle.getId())
                        .classType(vehicle.getClassType())
                        .licensePlate(vehicle.getLicensePlate())
                        .build()).toList())
                .build();
    }
}
