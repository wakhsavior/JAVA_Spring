package ru.gb.Homework.aspects;

import lombok.extern.java.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.logging.Level;

@Aspect
@Component
@Log
public class AspectLogger {
    @Before(value = "@annotation(TrackUserAction)")
    public void logExecuteMethod(JoinPoint joinPoint){
        log.log(Level.INFO,"HW_Sem_08: Метод "
                + joinPoint.getSignature().getName() + " Класса " +
                joinPoint.getTarget().getClass().getName() + " Был вызван");
    }
    @AfterReturning(value = "@annotation(TrackUserAction)",returning = "returnValue")
    public void logExecuteMethod(JoinPoint joinPoint, Object returnValue){
        log.log(Level.INFO,"HW_Sem_08: Метод " + joinPoint.getSignature().getName() +
                " Класса " + joinPoint.getTarget().getClass().getName() +
                " Был успешно выполнен и вернул значение: " + returnValue);
    }
    @AfterThrowing(value = "@annotation(TrackUserAction)",throwing = "e")
    public void logExecuteMethod(JoinPoint joinPoint,Exception e){
        log.log(Level.WARNING,"HW_Sem_08: Метод " + joinPoint.getSignature().getName() +
                " Класса " + joinPoint.getTarget().getClass().getName() +
                " закончился ошибкой: " + e.getMessage());
    }
}
