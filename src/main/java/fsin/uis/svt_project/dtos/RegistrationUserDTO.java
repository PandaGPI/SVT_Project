package fsin.uis.svt_project.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegistrationUserDTO {
    private String firstName;
    private String lastName;
    private String department;
    private String password;
    private String position;
    private String confirmPassword;
    private String email;
}
