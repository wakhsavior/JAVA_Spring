package ru.gb.Task_02_seminar_05.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.Task_02_seminar_05.model.Book;
import ru.gb.Task_02_seminar_05.repositories.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookService {
    private final BookRepository repository;

    /**
     * Получить все книги.
     * @return список книг.
     */
    public List<Book> getAllBooks(){
        return repository.findAll();
    }

    public Optional<Book> getBookById(Long id){
        return repository.findById(id);
    }

    public Book createBook(Book book){
        return repository.save(book);
    }

    public Book updateBook(Long id, Book bookDetails){
        Optional<Book> optionalBook = repository.findById(id);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            book.setTitle(bookDetails.getTitle());
            book.setAuthor(bookDetails.getAuthor());
            book.setPublicationYear(bookDetails.getPublicationYear());
            return repository.save(book);
        } else {
            throw new IllegalArgumentException("Book not found with id: " + id);
        }
    }

    public void deleteBook(Long id){
        repository.deleteById(id);
    }
}
