package ru.gb.MySpringSecurity.model;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String username;
    private String password;
    @OneToMany(mappedBy = "user")
//    , cascade = CascadeType.ALL , fetch = FetchType.LAZY)
//    @JoinColumn(name="userIdRef",referencedColumnName = "userId")
    private List<Authority> authorities = new ArrayList<>();

    public void addAuthority(Authority authority) {

        authorities.add(authority);
        authority.setUser(this);
    }

    public void removeAuthority(Authority authority) {
        authorities.remove(authority);
        authority.setUser(null);
    }

    @Override
    public String toString() {
        System.out.println("We are in ToString User method");
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", authorities=" + authorities +
                '}';
    }
}
