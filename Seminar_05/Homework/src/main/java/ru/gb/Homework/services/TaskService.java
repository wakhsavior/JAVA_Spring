package ru.gb.Homework.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.Homework.Exceptions.TaskNotFoundException;
import ru.gb.Homework.model.Task;
import ru.gb.Homework.model.TaskStatus;
import ru.gb.Homework.repositories.TaskRepository;

import java.util.List;
import java.util.Optional;

/**
 * Сервис доступа к репозиторию
 */
@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    /**
     * Запрос к репозиторию всех созданных задач
     * @return Список всех задач
     */
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    /**
     * Сохранение задач, используется для создания новых или внесения изменений в существующие заявки
     * @param task Объек класса Task для сохранения
     * @return Возвращает созданную заявку
     */
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    /**
     * Возвращает список задач с запрошенным статусом
     * @param status Статус запрашиваемых задач enum экземпляр
     * @return List заявок с одним статусом
     */

    public List<Task> getTasksByStatus(TaskStatus status) {
        return taskRepository.findTaskByStatus(status);
    }

    /**
     * Циклическая смена статуса задачи с номером ID
     * @param id ID задачи для внесения изменения статуса
     */
    public void changeTaskStatus(Long id) {
        TaskStatus status = TaskStatus.CREATED;
        Optional<Task> optTask = taskRepository.findById(id);
        if (optTask.isPresent()) {
            Task task = optTask.get();
            if (task.getStatus() == TaskStatus.CREATED) {
                status = TaskStatus.IN_PROGRESS;
            } else if (task.getStatus() == TaskStatus.IN_PROGRESS) {
                status = TaskStatus.COMPLETED;
            }
            taskRepository.changeTaskStatus(id, status);
        }
    }

    /**
     * Удаление задачи по ID
     * @param id ID задачи для удаления
     */
    public void deleteTaskById(Long id){
        taskRepository.deleteById(id);
    }

    /**
     * Получение эклемпляра класса Task по ID задачи. Выводит исключение в случае если заявка не найдена.
     * @param id ID искомой задачи
     * @return эклемпляр класса Task
     */

    public Task getTaskById(Long id){
        if (taskRepository.findById(id).isPresent()) {
            return taskRepository.findById(id).get();
        } else {
            throw new TaskNotFoundException("Task not found.",id);
        }
    }
}
