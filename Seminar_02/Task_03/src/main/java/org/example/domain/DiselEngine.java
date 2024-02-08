package org.example.domain;


import org.example.interfaces.iEngine;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
//@Lazy
public class DiselEngine implements iEngine {
    public DiselEngine() {
        System.out.println("Создан экземпляр DiselEngine");
    }

    // @Override
    public void startEngine() {
        System.out.println("Запущен Дизель 65р.л");
    }
}
