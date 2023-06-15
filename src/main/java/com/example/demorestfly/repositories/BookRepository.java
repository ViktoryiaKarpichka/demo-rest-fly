package com.tms.demospringboot.repositories;

import com.tms.demospringboot.entities.Book;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Modifying
    @Query("update Book as b set b.name =:name where b.id =:id")
    void updateBookName(@Param("id") Long id, @Param("name")String name);

    List<Book> findByParams(String description);
}
