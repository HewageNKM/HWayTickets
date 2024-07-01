package com.hewagenkm.vehicleservice.service;

import com.hewagenkm.vehicleservice.dto.VehicleDTO;
import com.hewagenkm.vehicleservice.entity.Vehicle;

import java.util.List;

public interface VehicleService {
     List<VehicleDTO> getVehicles(Integer page, Integer size, String sortBy, String sortOrder, String filter );
     void createVehicle(VehicleDTO vehicleDTO);
     void updateVehicle(VehicleDTO vehicleDTO, String id);
     VehicleDTO get(String id);
}
