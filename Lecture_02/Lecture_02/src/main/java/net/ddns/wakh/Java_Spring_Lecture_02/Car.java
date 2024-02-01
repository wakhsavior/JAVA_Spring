package net.ddns.wakh.Java_Spring_Lecture_02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class Car {
    /**
     * Внеднерение с помощью конструктора
     */
//    Engine engine;
//    public Car(Engine engine){
//        this.engine = engine;
//        engine.go();
//    }

    /**
     * Внедрение с помощью Setter
     */
//    public Car(){
//
//    }
//
//    public void setEngine(Engine engine) {
//        this.engine = engine;
//        engine.go();
//    }

    /**
     * Внедрение с помощью @Autowired
     */
    @Autowired
    Engine engine;
    public void start(){
        engine.go();
    }

}
