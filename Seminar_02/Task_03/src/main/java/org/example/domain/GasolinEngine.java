package org.example.domain;

import org.example.interfaces.iEngine;
import org.springframework.stereotype.Component;

@Component
public class GasolinEngine implements iEngine {
    public GasolinEngine() {
        System.out.println("Создан экземпляр GasolinEngine");
    }

    @Override
    public void startEngine() {
        System.out.println("Запущен Бензин 44р.л");
    }
}
