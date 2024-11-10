package org.gfg.JBDL_76_Minor1.repository;

import org.gfg.JBDL_76_Minor1.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findByBookNo(String bookNo);
}
