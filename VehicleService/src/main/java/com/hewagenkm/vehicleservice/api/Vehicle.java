package com.hewagenkm.vehicleservice.api;

import com.hewagenkm.vehicleservice.dto.VehicleDTO;
import com.hewagenkm.vehicleservice.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vehicles")
@RequiredArgsConstructor
public class Vehicle {
    private final VehicleService vehicleService;
    private final Logger logger = LoggerFactory.getLogger(Vehicle.class);

    @GetMapping
    List<VehicleDTO> getVehicles(Integer page, Integer size, String sortBy, String sortOrder, String filter) {
        logger.info("Getting all vehicles");
        return vehicleService.getVehicles(page, size, sortBy, sortOrder, filter);
    }

    @PostMapping
    void createVehicle(@Validated @RequestBody VehicleDTO vehicleDTO) {
        logger.info("Creating vehicle");
        vehicleService.createVehicle(vehicleDTO);
    }

    @PutMapping("/{id}")
    void updateVehicle(VehicleDTO vehicleDTO, @PathVariable String id) {
        logger.info("Updating vehicle with id: {}", "xxxxx");
        vehicleService.updateVehicle(vehicleDTO, id);
    }

    @GetMapping("/{id}")
    VehicleDTO getVehicle(@PathVariable String id) {
        logger.info("Getting vehicle with id: {}", "xxxxx");
        return vehicleService.get(id);
    }

}
