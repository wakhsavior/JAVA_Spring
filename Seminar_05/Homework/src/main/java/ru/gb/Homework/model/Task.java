package ru.gb.Homework.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private TaskStatus status;
    Date createDate;

    public Task(String description, TaskStatus status) {
        createDate = new Date();
        this.description = description;
        this.status = status;
        status = TaskStatus.CREATED;
    }
}
