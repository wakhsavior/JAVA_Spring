package ru.gb.books.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.books.store.Book;

public interface BookRepository extends JpaRepository<Book,Long> {

}
