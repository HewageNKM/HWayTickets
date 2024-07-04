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

    private Integer id;

    @NotEmpty
    @NotNull
    @Length(max = 100)
    private String userName;

    @NotEmpty
    @NotNull
    @Email
    @Length(max = 100)
    private String email;

    @NotEmpty
    @NotNull
    @Length(min = 8, max = 20)
    private String password;
}
