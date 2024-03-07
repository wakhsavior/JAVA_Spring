package ru.gb.Homework.repositories;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.gb.Homework.model.Task;
import ru.gb.Homework.model.TaskStatus;
import ru.gb.Homework.services.TaskService;

import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class TaskRepositoryIntegrationTest {

    @MockBean
    private TaskRepository taskRepository;
    @Autowired
    TaskService taskService;

    @Test
    @DisplayName("WorkWithTaskTest")
    public void WorkWithTaskTest() {
        Task task1 = new Task();
        Task task2 = new Task();
        task1.setId(1L);
        task2.setId(2L);
        task1.setDescription("Test_Task_1");
        task2.setDescription("Test_Task_2");
        task1.setStatus(TaskStatus.COMPLETED);
        task2.setStatus(TaskStatus.IN_PROGRESS);

        given(taskRepository.findById(task1.getId())).willReturn(Optional.of(task1));
        given(taskRepository.findById(task2.getId())).willReturn(Optional.of(task2));

        Long task2ID = task2.getId();

        taskService.changeTaskStatus(task1.getId());
        taskService.deleteTaskById(task2.getId());

        verify(taskRepository).changeTaskStatus(task1.getId(),TaskStatus.CREATED);
        verify(taskRepository).deleteById(2L);
    }

}
