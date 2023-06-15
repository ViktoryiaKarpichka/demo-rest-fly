package com.tms.demospringboot.services;

import com.tms.demospringboot.entities.Book;
import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> getBooks();

    Optional<Book> getBookById(Long id);

    void saveOrUpdate(Book book);

    void update(Long id, Book book);

    void updateBookName(Long id, String name);

    List<Book> findByParams(String description);

    void deleteById(Long id);

}
