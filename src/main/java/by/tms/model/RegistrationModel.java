package by.tms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationModel {
    @NotNull
    @NotBlank
    @NotEmpty
    private String name;
    @NotNull
    @NotBlank
    @NotEmpty
    private String username;
    @NotNull
    @NotBlank
    @NotEmpty
    private String password;
    @NotNull
    @NotBlank
    @NotEmpty
    private String city;
    @NotNull
    @NotBlank
    @NotEmpty
    private String street;
    @NotNull
    @NotBlank
    @NotEmpty
    private String numberMTC;
    @NotNull
    @NotBlank
    @NotEmpty
    private String numberA1;
    @NotNull
    @NotBlank
    @NotEmpty
    private String numberLife;
}
