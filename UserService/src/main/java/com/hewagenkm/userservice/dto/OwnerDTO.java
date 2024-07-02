package com.hewagenkm.userservice.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class OwnerDTO {


    private Integer id;

    @NotNull
    @NotEmpty
    @Length(min = 13, max = 13)
    private String iDNumber;

    @NotNull
    @NotEmpty
    @Length(min = 1, max = 100)
    private String fullName;

    @Length(max = 100)
    private String email;

    @Length(max = 13)
    private String phone;

    @NotNull
    @NotEmpty
    @Length( max = 100)
    private String address;

    private List<VehicleDTO> vehicleDTOS;
}
