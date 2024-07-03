package com.hewagenkm.userservice.service;

import com.hewagenkm.userservice.dto.OwnerDTO;
import com.hewagenkm.userservice.dto.VehicleDTO;
import com.hewagenkm.userservice.entity.Owner;
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
    public void addOwner(OwnerDTO dto) {
        ownerRepository.save(
                Owner.builder()
                        .iDNumber(dto.getIDNumber())
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
    public List<OwnerDTO> getOwners(int page, int size, String filter, String sort) {
        logger.info("Getting all owners");
        return ownerRepository.findAll().stream().map(owner -> OwnerDTO.builder()
                .id(owner.getId())
                .iDNumber(owner.getIDNumber())
                .fullName(owner.getFullName())
                .email(owner.getEmail())
                .phone(owner.getPhone())
                .address(owner.getAddress())
                .vehicleDTOS(owner.getVehicles().stream().map(vehicle -> VehicleDTO.builder()
                        .id(vehicle.getId())
                        .classType(vehicle.getClassType())
                        .licensePlate(vehicle.getLicensePlate())
                        .build()).toList())
                .build()).toList();
    }

    @Override
    public void updateOwner(Integer id, OwnerDTO dto) {
        Owner owner = ownerRepository.findById(id).orElseThrow(() -> new RuntimeException("Owner not found"));
        owner.setIDNumber(dto.getIDNumber());
        owner.setFullName(dto.getFullName());
        owner.setEmail(dto.getEmail());
        owner.setPhone(dto.getPhone());
        owner.setAddress(dto.getAddress());
        owner.setVehicles(dto.getVehicleDTOS().stream().map(vehicleDTO -> Vehicle.builder()
                .id(vehicleDTO.getId())
                .classType(vehicleDTO.getClassType())
                .licensePlate(vehicleDTO.getLicensePlate())
                .build()).toList());
        ownerRepository.save(owner);
        logger.info("Owner updated");
    }

    @Override
    public void deleteOwner(Integer id) {
        ownerRepository.deleteById(id);
        logger.info("Owner deleted");
    }

    @Override
    public OwnerDTO getOwner(Integer id) {
        Owner owner = ownerRepository.findById(id).orElseThrow(() -> new RuntimeException("Owner not found"));
        logger.info("Getting owner with id: {}", id);
        return getOwnerDTO(owner);
    }

    @Override
    public OwnerDTO getOwnerByIDNumber(String IDNumber) {
        Owner owner = ownerRepository.findByIDNumber(IDNumber).orElseThrow(() -> new RuntimeException("Owner not found"));
        logger.info("Getting owner with IDNumber: {}", IDNumber);
        return getOwnerDTO(owner);
    }

    private OwnerDTO getOwnerDTO(Owner owner) {
        return OwnerDTO.builder()
                .id(owner.getId())
                .iDNumber(owner.getIDNumber())
                .fullName(owner.getFullName())
                .email(owner.getEmail())
                .phone(owner.getPhone())
                .address(owner.getAddress())
                .vehicleDTOS(owner.getVehicles().stream().map(vehicle -> VehicleDTO.builder()
                        .id(vehicle.getId())
                        .classType(vehicle.getClassType())
                        .licensePlate(vehicle.getLicensePlate())
                        .build()).toList())
                .build();
    }
}
