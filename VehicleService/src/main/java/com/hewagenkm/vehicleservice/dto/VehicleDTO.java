package com.hewagenkm.vehicleservice.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class VehicleDTO {

    private Integer id;

    @NotNull
    @NotEmpty
    @Length(max = 10)
    private String licensePlate;

    @NotNull
    @NotEmpty
    @Length(max = 2)
    private String classType;

    private Integer ownerId;
}
