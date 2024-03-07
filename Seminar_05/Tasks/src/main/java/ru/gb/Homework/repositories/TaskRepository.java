package ru.gb.Homework.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.Homework.model.Task;
import ru.gb.Homework.model.TaskStatus;

import java.util.List;

/**
 * Репозиторий доступа к данным в БД, используется Postgres установленный в контейнере на отдельной машине
 */
@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {

    /**
     * Назначает запрос в базу данных на выгрузку листа задач с определенным статусом
     * SQL запрос имеет вид native
     * @param status Экземпляр enum класса TaskStatus
     * @return Лист задач с заданным статусом
     */
    @Query(value = "SELECT * FROM tasks WHERE status = :status",nativeQuery = true)
    List<Task> findTaskByStatus(@Param("status") TaskStatus status);

    /**
     * Устанавливает новый статус задаче. Пришлось установить аннотацию @Transactional, без нее выдавал Exception.
     * SQL запрос имеет вид native
     * @param id Номер изменяемой задачи
     * @param status Новый статус
     */
    @Modifying
    @Transactional
    @Query(value = "update tasks set status = :status where id = :id",nativeQuery = true)
    void changeTaskStatus(@Param("id") Long id, @Param("status") TaskStatus status);
}
