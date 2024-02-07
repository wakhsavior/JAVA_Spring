package net.ddns.wakh.HomeWork.domain;

import lombok.Data;

/**
 * Класс пользователя, заполнение с использование lombok
 */
@Data
public class User {
    private Long id;
    private String name;
    private int age;
    private String email;

    public User(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }
}
