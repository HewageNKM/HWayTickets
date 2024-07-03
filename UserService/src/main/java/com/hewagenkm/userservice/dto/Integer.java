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
public class Integer {


    private java.lang.Integer id;

    @NotNull
    @NotEmpty
    @Length(min = 10, max = 13)
    private String nic;

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

    private List<VehicleDTO> vehicles;
}
