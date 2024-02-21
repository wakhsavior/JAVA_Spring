package ru.gb.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.Objects;
import java.util.Optional;

@Aspect
public class LoggingAspect {
    @Around("execution(* ru.gb.services.*.*(..))")
    //https://docs.spring.io/spring-framework/reference/core/aop/ataspectj.html

    public Object log(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("Инжектированное сообщение и функционал");
        Object object = joinPoint.proceed();
        return object;

    }
}
