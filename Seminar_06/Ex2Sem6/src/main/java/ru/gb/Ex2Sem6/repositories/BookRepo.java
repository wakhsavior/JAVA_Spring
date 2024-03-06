package ru.gb.Ex2Sem6.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.Ex2Sem6.model.Book;

public interface BookRepo extends JpaRepository<Book,Long> {
}
