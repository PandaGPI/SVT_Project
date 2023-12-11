package fsin.uis.svt_project.models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "depName")
    private String department;

    @ManyToMany(mappedBy = "departments")
    Set<User> users;


    public Department() {
    }

    public Department(String department, Set<User> users) {
        this.department = department;
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = this.department;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}


