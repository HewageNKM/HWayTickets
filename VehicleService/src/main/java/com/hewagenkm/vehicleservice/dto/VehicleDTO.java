package com.hewagenkm.vehicleservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class VehicleDTO {

    private Integer id;
    private String licensePlate;
    private String classType;
    private Integer ownerId;
}
