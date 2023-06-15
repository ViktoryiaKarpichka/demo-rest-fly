package com.tms.demospringboot.services.impl;

import com.tms.demospringboot.entities.Book;
import com.tms.demospringboot.repositories.BookRepository;
import com.tms.demospringboot.services.BookService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public void saveOrUpdate(Book book) {
        bookRepository.save(book);
    }

    @Override
    @Transactional
    public void update(Long id, Book book) {
        Book bookDb = bookRepository.findById(id)
                                    .orElseThrow(RuntimeException::new);
        bookDb.setName(book.getName());
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
        bookRepository.deleteById(id);
    }
}
