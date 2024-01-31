package org.example.domain;

import org.example.interfaces.iEngine;
import org.springframework.stereotype.Component;

@Component
public class Car {

    private iEngine carEngine;
    private String model = "X1";
    private String made = "Haval";

    public iEngine getCarEngine() {
        return carEngine;
    }

    public void setCarEngine(iEngine carEngine) {
        this.carEngine = carEngine;
    }

    public Car(iEngine carEngine) {
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
    public void go()
    {
        carEngine.startEngine();
    }
}
