package ru.gb.Homework.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import ru.gb.Homework.model.Task;


@Aspect
@Component
public class TaskStatusAspect {
    @Around("execution(* ru.gb.Homework.services.TaskService.saveTask(..))")
    public Object logTaskStatus(ProceedingJoinPoint jp) throws Throwable {
        Object [] args = jp.getArgs();

        Task task = new Task();
        task.setDescription("Hello!");
        Object [] newArgs = {task};


        System.out.println("Сигнатура вызываемого метода " + jp.getSignature());
        System.out.println("Создание новой задачи: " + task.toString());
        return jp.proceed(newArgs);
    }

}
