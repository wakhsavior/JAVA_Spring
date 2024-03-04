package ru.gb.MySpringSecurity.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="authorities")
@NoArgsConstructor
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ManyToOne
//            (cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    @JoinColumn(name="user_id",nullable = false)
     private User user;
}