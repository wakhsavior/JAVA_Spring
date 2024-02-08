package org.example.config;

import org.example.domain.Car;
import org.example.domain.Engine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan(basePackages = "org.example.domain")
public class ProjectConfiguration {
//    @Bean
//    Engine engin1()
//    {
//        Engine eng = new Engine();
//        eng.setTypeEngine("Бензиновый");
//        return eng;
//    }
//    @Bean(name="BMW")
//    Car car1()
//    {
//        Car obCar = new Car(engin1());
//        obCar.setModel("X1");
//        obCar.setMade("BMW");
//        return obCar;
//    }
//    @Bean(name="Audi")
//    @Primary
//    Car car2()
//    {
//        Car obCar = new Car();
//        obCar.setModel("S8");
//        obCar.setMade("Audi");
//        return obCar;
//    }
//
//    @Bean(name="Haval")
//    Car car3()
//    {
//        Car obCar = new Car();
//        obCar.setModel("H7");
//        obCar.setMade("HAVAL");
//        return obCar;
//    }
    @Bean
    String hello(){return "Hello";}
    @Bean
    Integer ten(){return 10;}
}
