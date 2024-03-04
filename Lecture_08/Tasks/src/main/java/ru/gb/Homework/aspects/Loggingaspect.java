package ru.gb.Homework.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Loggingaspect {
    @Before("execution (* ru.gb.Homework.controllers.*.*(..))")
    public void logBeforeMethodCall(JoinPoint joinPoint){
        System.out.println("Метод "+ joinPoint.getSignature().getName() + " был вызван.");
    }
}
