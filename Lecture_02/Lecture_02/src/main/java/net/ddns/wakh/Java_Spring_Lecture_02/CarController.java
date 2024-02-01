package net.ddns.wakh.Java_Spring_Lecture_02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {
    @Autowired
    Car car;
    @GetMapping("/car")
    public String startCar(){
        car.start();
    return "Автомобиль запущен";
    }
}
