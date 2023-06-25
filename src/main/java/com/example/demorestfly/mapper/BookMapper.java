package com.example.demorestfly.mapper;

import com.example.demorestfly.dto.BookDto;
import com.example.demorestfly.entities.Book;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookMapper {
    @Mapping(target = "description", source = "bookDto.desc")
    @Mapping(target = "id", ignore = true)
    Book toEntity(BookDto bookDto);

    @Mapping(target = "desc", source = "book.description")
    BookDto toDto(Book book);

    @Mapping(target = "desc", source = "book.description")
    List<BookDto> toDto(List<Book> book);

}
