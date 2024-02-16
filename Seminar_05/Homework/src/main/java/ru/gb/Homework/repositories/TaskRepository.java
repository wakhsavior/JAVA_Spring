package ru.gb.Homework.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.gb.Homework.model.Task;
import ru.gb.Homework.model.TaskStatus;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {

    @Query("SELECT * FROM tasks WHERE status=: status")
    List<Task> findTaskByStatus(TaskStatus status);
    @Modifying
    @Query("UPDATE tasks SET  status = :status WHERE id = :id")
    void changeTaskStatus(Long id, TaskStatus status);
}
