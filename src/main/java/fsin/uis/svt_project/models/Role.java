package fsin.uis.svt_project.models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "role", nullable = false)
    private String nameRole;

    @ManyToMany(mappedBy = "roles")
    Set<User> users;

    public Role() {

    }

    public Role(String nameRole, Set<User> users) {
        this.nameRole = nameRole;
        this.users = users;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameRole() {
        return nameRole;
    }

    public void setNameRole(String nameRole) {
        this.nameRole = nameRole;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
