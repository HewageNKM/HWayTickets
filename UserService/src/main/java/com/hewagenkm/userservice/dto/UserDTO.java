package com.hewagenkm.userservice.dto;

import jakarta.validation.constraints.Email;
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
public class UserDTO {

    @NotEmpty
    @NotNull
    @Email
    private String email;
    @NotEmpty
    @NotNull
    @Length(min = 8)
    private String password;
}
