package ru.gb.Task_02_seminar_05.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.Task_02_seminar_05.model.Book;

public interface BookRepository extends JpaRepository<Book,Long> {
}
