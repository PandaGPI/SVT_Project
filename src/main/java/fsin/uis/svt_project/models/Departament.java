package fsin.uis.svt_project.models;

import jakarta.persistence.*;

@Entity
public class Departament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "depName")
    private String departament;



    public Departament() {

    }

    public Departament(String departament) {
        this.departament = departament;
    }
}
