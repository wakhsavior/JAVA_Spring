package ru.gb.Homework.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.Homework.Exceptions.TaskNotFoundException;
import ru.gb.Homework.model.Task;
import ru.gb.Homework.model.TaskStatus;
import ru.gb.Homework.repositories.TaskRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> getTasksByStatus(TaskStatus status) {
        return taskRepository.findTaskByStatus(status);
    }

    public void changeTaskStatus(Task task, TaskStatus status) {
        taskRepository.changeTaskStatus(task.getId(), status);
    }

    public Task getTaskById(Long id) throws TaskNotFoundException{
        if (taskRepository.findById(id).isPresent()) {
            return taskRepository.findById(id).get();
        } else {
            throw new TaskNotFoundException("Task not found.",id);
        }
    }
}
