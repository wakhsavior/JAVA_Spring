package ru.gb.Homework.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gb.Homework.model.Task;
import ru.gb.Homework.model.TaskStatus;
import ru.gb.Homework.services.FileGateway;
import ru.gb.Homework.services.TaskService;

import java.util.logging.Level;

/**
 * Контроллер работы с задачами, обрабатывает путь /task
 */
@Controller
@RequestMapping("/tasks")
@Log
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;
    private final FileGateway fileGateway;

    /**
     * Реагирует на запрос /task и /task/. Выводит основную страницу работы с задачами.
     * Передает в модель 3 списка задач с разными статусами для формирования отдельных столбцов
     * @param model
     * @return Выводит шаблон основной страницы которая собирается из кусков с помощью ThymeLeaf
     */
    @GetMapping({"","/"})
    public String mainPage(Model model){
        model.addAttribute("title","Tasks");
        model.addAttribute("tasks_created",taskService.getTasksByStatus(TaskStatus.CREATED));
        model.addAttribute("tasks_inprogress",taskService.getTasksByStatus(TaskStatus.IN_PROGRESS));
        model.addAttribute("tasks_completed",taskService.getTasksByStatus(TaskStatus.COMPLETED));
        log.log(Level.INFO, "Вывод основной страницы заявок");
        return "main_tmpl.html";
    }

    /**
     * Метод создания новой задачи, из формы получает необходимые данные для создания экземпляра класса Task.
     *
     * @param task Сформированный на основе данных экземпляр класса Task
     * @param model
     * @return Перенаправляет на основную страницу задач
     */
    @PostMapping("/addtask")
    public String addTask(Task task, Model model){
        taskService.saveTask(task);
        log.log(Level.INFO,"Created Task: " + task.getDescription());
        fileGateway.writeToFile(task.getId() + ".txt", task.getDescription());
        return "redirect:/tasks";

    }

    /**
     * Метод удаления задачи по ссылке /deltask/{id}, извлекает номер заявки для удаления из пути
     * @param model
     * @param id ID заявки для удаления
     * @return Перенаправляет на основную страницу задач
     */
    @GetMapping("/deltask/{id}")
    public String delTask(Model model, @PathVariable("id") Long id){
        taskService.deleteTaskById(id);
        log.log(Level.INFO,"Deleted Task: " + id);
        return "redirect:/tasks";
    }

    /**
     * Метод циклического изменения статуса задачи с ID при вызове меняет статус на следующий
     * @param id ID задачи для изменения статуса
     * @return Перенаправляет на основную страницу задач
     */
    @GetMapping("/changestatus/{id}")
    public String changeStatus(@PathVariable  Long id){
        log.log(Level.INFO,"Change status for Task: " + id);
        taskService.changeTaskStatus(id);
        return "redirect:/tasks";
    }
}
