package ru.gb.Homework.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import ru.gb.Homework.model.Task;


@Aspect
@Component
public class TaskStatusAspect {
    @AfterReturning(pointcut = "execution(* ru.gb.Homework.services.TaskService.saveTask(..))", returning = "task")
    public void logTaskStatus(JoinPoint jp, Task task) {
        Task taskOverride = new Task();
        taskOverride.setDescription("Hello!");
        task = taskOverride;

        System.out.println("Сигнатура вызываемого метода " + jp.getSignature());
        System.out.println("Создание новой задачи: " + task.toString());
    }

}
