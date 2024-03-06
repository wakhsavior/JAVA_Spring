package ru.gb.Ex2Sem6.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String author;
    private String title;
    @ManyToOne
    @JoinColumn(name = "reader_id")
    private Reader reader;

    public Book(String author, String title) {
        this.author = author;
        this.title = title;
    }
}
