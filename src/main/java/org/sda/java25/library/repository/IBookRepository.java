package org.sda.java25.library.repository;

import org.sda.java25.library.model.Book;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface IBookRepository extends CrudRepository<Book, Long> {

    @Override
    List<Book> findAll();
}
