package ru.gb.Homework.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ChangeReturnValueAspect {
    @AfterReturning(pointcut = "execution(* ru.gb.Homework.controllers.BaseController.getHomePage(..))", returning = "result")
    public void changeString(JoinPoint joinPoint, String result){
        System.out.println("Аспект изменения переменной был вызван " + result);
        result = "redirect:/aaaaaaa";
        System.out.println("Аспект изменения переменной был вызван " + result);
    }
}
