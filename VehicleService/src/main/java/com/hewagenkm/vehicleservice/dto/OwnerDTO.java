package com.hewagenkm.vehicleservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OwnerDTO {
    private Integer id;
    private String nic;
    private String fullName;
    private String email;
    private String phone;
    private String address;
}
