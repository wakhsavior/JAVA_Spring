package net.ddns.wakh.Java_Spring_Lecture_02;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Qualifier
@Profile(("local"))
public class LocalEngine implements Engine{
    public LocalEngine(){
        System.out.println("Двигатель запущен на ноутбуке");
    }
    public void go(){
        System.out.println("Поехали медленно!");
    }
}
