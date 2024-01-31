package org.example.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class Car {
//    @Autowired
    private Engine carEngine;
    private String model = "X1";
    private String made = "Haval";

    public Car(Engine carEngine) {
        this.carEngine = carEngine;
        System.out.println("Автомобиль создан!");
    }

        public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMade() {
        return made;
    }

    public void setMade(String made) {
        this.made = made;
    }
    @Override
    public String toString() {
        return "Car{" +
                "carEngine=" + carEngine +
                ", model='" + model + '\'' +
                ", made='" + made + '\'' +
                '}';
    }
}
