package ru.gb.TestH2Objects.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="authroles")
public class AuthRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @Override
    public String toString() {
        return "AuthRole{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", user=" + user +
                '}';
    }
}
