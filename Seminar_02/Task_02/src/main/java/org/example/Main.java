package org.example;

import org.example.config.ProjectConfiguration;
import org.example.domain.Car;
import org.example.domain.Engine;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);
        Car simpleCar = context.getBean(Car.class);
        Engine eng = context.getBean(Engine.class);
        System.out.println(simpleCar);
        System.out.println(eng);
    }
}