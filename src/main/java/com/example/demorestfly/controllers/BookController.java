package com.tms.demospringboot.controllers;

import com.tms.demospringboot.entities.Book;
import com.tms.demospringboot.services.BookService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @GetMapping("/all")
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    @GetMapping("/{id}")
    public Optional<Book> getBookById(@PathVariable Long id) {
        return Optional.ofNullable(bookService.getBookById(id)
                                              .orElseThrow(RuntimeException::new));
    }

    @PostMapping
    public void save(@RequestBody Book book) {
        bookService.saveOrUpdate(book);
    }

    @PutMapping("/{book_id}")
    public void update(@PathVariable("book_id") Long id, @RequestBody Book book) {
        bookService.update(id, book);
    }

    @PutMapping("/{book_id}/{book_name}")
    public void updateBookDescription(@PathVariable("book_id") Long id, @PathVariable("book_name") String name) {
        bookService.updateBookName(id, name);
    }

    @GetMapping("/all/{description}")
    List<Book> findByParams(@PathVariable("description") String description) {
        return bookService.findByParams(description);
    }

    @DeleteMapping("/{id}")
    public void deleteBookById(@PathVariable Long id) {
        bookService.deleteById(id);
    }

}
