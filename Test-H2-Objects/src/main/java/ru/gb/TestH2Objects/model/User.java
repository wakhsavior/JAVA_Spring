package ru.gb.TestH2Objects.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String password;
    @OneToMany(mappedBy = "user")
    private List<AuthRole> roles = new ArrayList<>();
    public void addRole(AuthRole role){
        roles.add(role);
        role.setUser(this);
    }
    public void removeRole(AuthRole role){
        roles.remove(role);
        role.setUser(null);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                '}';
    }
}
