package com.example.springboot.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    @Schema(description = "User first name")
    @NotEmpty(message = "firstName should not be null or empty")
    private String firstName;
    @Schema(description = "User last name")
    @NotEmpty(message = "lastName should not be null or empty")
    private String lastName;
    @Schema(description = "User email address")
    @NotEmpty(message = "Email should not be null or empty")
    @Email(message = "email address should be valid")
    private String email;
}
