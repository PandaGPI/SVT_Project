package fsin.uis.svt_project.dtos;

import lombok.Data;

@Data
public class RegistrationUserDTO {
    private String firstName;
    private String lastName;
    private String department;
    private String confirmPassword;
    private String email;
}
