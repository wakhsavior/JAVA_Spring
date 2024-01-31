package org.example;

import org.example.config.ProjectConfiguration;
import org.example.domain.Car;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.annotation.AnnotationConfigurationException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        Car bmw = new Car();
//        bmw.setModel("X1");
//        bmw.setMade("BMW");
        var context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);
        Car simpleCar = context.getBean("Haval",Car.class);
        System.out.println(simpleCar.getModel()+" "+ simpleCar.getMade());
        System.out.println(context.getBean(String.class));
        System.out.println(context.getBean(Integer.class));
    }
}