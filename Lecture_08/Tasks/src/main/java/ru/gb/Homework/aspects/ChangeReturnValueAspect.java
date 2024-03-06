package ru.gb.Homework.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ChangeReturnValueAspect {
    @AfterReturning(value = "execution(* ru.gb.Homework.controllers.BaseController.getHomePage(..))",returning = "result")
    public Object changeString(JoinPoint joinPoint, Object result){
        System.out.println("Аспект изменения переменной был вызван " + result.toString());

        result = "redirect:/aaaaaaa";
        System.out.println("Аспект изменения переменной был вызван " + result);
        return result;
    }
}
