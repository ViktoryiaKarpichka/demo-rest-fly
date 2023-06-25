package com.example.demorestfly.services;

import com.example.demorestfly.dto.BookDto;
import com.example.demorestfly.entities.Book;
import java.util.List;

public interface BookService {
    List<BookDto> getBooks();

    BookDto getBookById(Long id);

    BookDto addBook(BookDto bookDto);

    BookDto update(Long id, BookDto bookDto);

    void updateBookName(Long id, String name);

    List<Book> findByParams(String description);

    void deleteById(Long id);

}
