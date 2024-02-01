package net.ddns.wakh.MyFirstWebApp;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/task")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    @GetMapping
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }
    @GetMapping("/{id}")
    public Task getById(@PathVariable UUID id){
        return taskService.getTask(id);
    }
    @PostMapping()
    public Task addById(@RequestBody Task task){
        return taskService.addTask(task);
    }
    @PutMapping("/{id}")
    public Task getById(@PathVariable UUID id,@RequestBody Task task){
        return taskService.updateTask(id,task);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id){
        taskService.deleteTask(id);
    }
}
