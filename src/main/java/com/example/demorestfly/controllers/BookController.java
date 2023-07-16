package com.example.demorestfly.controllers;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.example.demorestfly.dto.BookDto;
import com.example.demorestfly.entities.Book;
import com.example.demorestfly.model.ExceptionResponse;
import com.example.demorestfly.services.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Min;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Book", description = "Book management APIs")
@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @Operation(
            summary = "Find all Books",
            description = "Find all Books in DB with name and description.",
            tags = "get")
    @ApiResponses({

            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = BookDto.class), mediaType = APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema(implementation = ExceptionResponse.class), mediaType = APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema(implementation = ExceptionResponse.class), mediaType = APPLICATION_JSON_VALUE)})})

    @GetMapping
    public ResponseEntity<List<BookDto>> getBooks() {
        return ResponseEntity.ok(bookService.getBooks());
    }

    @Operation(
            summary = "Find a Book by Id",
            description = "Get a Book object by specifying its id.",
            tags = "get")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = BookDto.class), mediaType = APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema(implementation = ExceptionResponse.class), mediaType = APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema(implementation = ExceptionResponse.class), mediaType = APPLICATION_JSON_VALUE)})})

    @GetMapping("/{id}")
    public ResponseEntity<BookDto> getOneBookById(@PathVariable("id") @Min(1) Long id) {
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    @Operation(
            summary = "Create a Book by Id",
            description = "Create a Book object by specifying its id.",
            tags = "post")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = BookDto.class), mediaType = APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema(implementation = ExceptionResponse.class), mediaType = APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema(implementation = ExceptionResponse.class), mediaType = APPLICATION_JSON_VALUE)})})

    @PostMapping
    public ResponseEntity<BookDto> create(@RequestBody BookDto bookDto) {
        return ResponseEntity.ok(bookService.addBook(bookDto));
    }

    @Operation(
            summary = "Update a Book by Id",
            description = "Update a Book object by specifying its id.",
            tags = "put")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = BookDto.class), mediaType = APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema(implementation = ExceptionResponse.class), mediaType = APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema(implementation = ExceptionResponse.class), mediaType = APPLICATION_JSON_VALUE)})})

    @PutMapping("/{book_id}")
    public void update(@PathVariable("book_id") Long id, @RequestBody BookDto bookDto) {
        bookService.update(id, bookDto);
    }

    @Operation(
            summary = "Delete a Book by Id",
            description = "Delete a Book object by specifying its id.",
            tags = "delete")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = BookDto.class), mediaType = APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema(implementation = ExceptionResponse.class), mediaType = APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema(implementation = ExceptionResponse.class), mediaType = APPLICATION_JSON_VALUE)})})

    @DeleteMapping("/{id}")
    public void deleteBookById(@PathVariable Long id) {
        bookService.deleteById(id);
    }

    @PutMapping("/{book_id}/{book_name}")
    public void updateBookName(@PathVariable("book_id") Long id, @PathVariable("book_name") String name) {
        bookService.updateBookName(id, name);
    }
    //Если я оставляю этот метод, то не работает метод getOneBookById. Он не понимает какой метод выбрать IllegalStateException
// Как можно это решить, чтоб оба работали
    @GetMapping("/{description}")
    List<Book> findByParams(@PathVariable("description") String description) {
        return bookService.findByParams(description);
    }

}
