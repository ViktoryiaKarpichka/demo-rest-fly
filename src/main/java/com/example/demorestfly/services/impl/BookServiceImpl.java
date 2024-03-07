package com.example.demorestfly.services.impl;

import com.example.demorestfly.dto.BookDto;
import com.example.demorestfly.entities.Book;
import com.example.demorestfly.exception.BookNotFoundException;
import com.example.demorestfly.mapper.BookMapper;
import com.example.demorestfly.repositories.BookRepository;
import com.example.demorestfly.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;


    @Override
    public List<BookDto> getBooks() {
        List<Book> dbBooks = bookRepository.findAll();
        return bookMapper.toDto(dbBooks);
    }

    @Override
    public BookDto getBookById(Long id) {
        return bookMapper.toDto(bookRepository.findById(id).orElseThrow(BookNotFoundException::new));
    }

    @Override
    public BookDto addBook(BookDto bookDto) {
        Book book = bookMapper.toEntity(bookDto);
        book = bookRepository.save(book);
        return Optional.ofNullable(bookMapper.toDto(book)).orElseThrow(BookNotFoundException::new);
    }


    @Override
    public BookDto update(Long id, BookDto bookDto) {
        Book book = bookMapper.toEntity(bookDto);
        Book bookDb = bookRepository.findById(id)
                .orElseThrow(BookNotFoundException::new);
        bookDb.setName(book.getName());
        bookDb.setDescription(book.getDescription());
        return bookMapper.toDto(bookDb);
    }

    @Override
    @Transactional
    public void updateBookName(Long id, String name) {
        bookRepository.updateBookName(id, name);
    }

    @Override
    public List<Book> findByParams(String description) {
        return bookRepository.findByParams(description);
    }

    @Override
    public void deleteById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
        bookRepository.deleteById(book.getId());
    }

}
