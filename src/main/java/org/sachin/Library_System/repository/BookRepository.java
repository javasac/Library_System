package org.sachin.Library_System.repository;

import org.sachin.Library_System.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findByBookNo(String bookNo);
}
