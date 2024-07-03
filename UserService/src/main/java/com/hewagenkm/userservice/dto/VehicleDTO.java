package com.hewagenkm.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class VehicleDTO {

    private java.lang.Integer id;
    private String licensePlate;
    private String classType;
    private java.lang.Integer ownerId;
}
