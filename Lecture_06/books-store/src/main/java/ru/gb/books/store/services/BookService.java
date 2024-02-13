package ru.gb.books.store.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.books.store.Book;
import ru.gb.books.store.repositories.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    public List<Book> findAll (){
        return bookRepository.findAll();
    }
    public Optional<Book> findById(Long id){
        return bookRepository.findById(id);
    }
    public Book save(Book book){
        return bookRepository.save(book);
    }
    public void deleteById(Long id){
        bookRepository.deleteById(id);
    }
}
