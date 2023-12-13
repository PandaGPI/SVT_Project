package fsin.uis.svt_project.dtos;

import lombok.Data;

@Data
public class JwtRequest {
    private String firstName;
    private String password;
}
