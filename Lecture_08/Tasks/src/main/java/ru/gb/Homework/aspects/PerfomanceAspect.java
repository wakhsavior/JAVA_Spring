package ru.gb.Homework.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import javax.swing.plaf.PanelUI;

@Aspect
@Component
public class PerfomanceAspect {
    @Around("execution (* ru.gb.Homework.controllers.*.*(..))")
    public Object measureMethodExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        long elapsedTime = System.currentTimeMillis() - start;
        System.out.println("Метод "+ proceedingJoinPoint.getSignature().getName() + " выполнялся " + elapsedTime + " мсек.");
        return result;
    }
}
