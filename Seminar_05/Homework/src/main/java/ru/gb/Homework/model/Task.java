package ru.gb.Homework.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

/**
 * Класс задачи, содержит ID, описание, статус, время создания. Время создания заполняется
 * автоматически конструктором во время создания экземпляра. ID назначается средствами БД
 */
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
    @Column(nullable = false)
    Date createDate;

    public Task() {
        createDate = new Date();
        this.status = TaskStatus.CREATED;
    }
}
