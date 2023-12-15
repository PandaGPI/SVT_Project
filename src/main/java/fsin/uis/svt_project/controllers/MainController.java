package fsin.uis.svt_project.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
public class MainController {

    @GetMapping("/admin")
    public String adminData() {
        return "Hello Admin";
    }

    @GetMapping("/unsecured")
    public String unsecuredData() {
        return "Hello Anonimus";
    }

    @GetMapping("/secured")
    public String securedData() {
        return "Secured";
    }

    @GetMapping("/info")
    public String userData(Principal principal) {
        return principal.getName();
    }
}
