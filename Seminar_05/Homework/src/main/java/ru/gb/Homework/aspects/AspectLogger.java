package ru.gb.Homework.aspects;

import lombok.extern.java.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.logging.Level;

@Aspect
@Component
@Log
public class AspectLogger {
    @After("execution (* ru.gb.Homework.controllers.*.*(..))")
    public void logBeforeMethodCall(JoinPoint joinPoint){
        log.log(Level.INFO,"Метод " + joinPoint.getSignature().getName() + " Успешно выполнен");
    }
}
