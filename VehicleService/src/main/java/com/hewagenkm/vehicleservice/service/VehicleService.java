package com.hewagenkm.vehicleservice.service;

import com.hewagenkm.vehicleservice.dto.VehicleDTO;

import java.util.List;

public interface VehicleService {
    List<VehicleDTO> getVehicles(Integer page, Integer size, String sortBy, String sortOrder, String filter);

    void createVehicle(VehicleDTO vehicleDTO);

    void updateVehicle(VehicleDTO vehicleDTO, Integer id);

    VehicleDTO getVehicle(Integer id);

    VehicleDTO getVehicleByLicense(String id);

    void deleteVehicle(Integer id);
}
