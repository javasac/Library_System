package org.sachin.Library_System.service.impl;

import org.sachin.Library_System.dto.response.BookFilterResponse;
import org.sachin.Library_System.enums.Operator;
import org.sachin.Library_System.model.Book;
import org.sachin.Library_System.repository.BookRepository;
import org.sachin.Library_System.service.BookFilterStratergy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookNoFilterImpl implements BookFilterStratergy {

    @Autowired
    private BookRepository bookRepository;
    @Override
    public List<Book> getFilteredBook(Operator operator, String value) {
        if(!operator.equals(Operator.EQUALS)){
            throw  new IllegalArgumentException("Only Equals is expected with book no");
        }
        List<Book> books = bookRepository.findByBookNo(value);
        return books;
//        return books.
//                stream().
//                map(book -> convertToBookFilterResponse(book)).
//                collect(Collectors.toList());
    }

    private BookFilterResponse convertToBookFilterResponse(Book book) {
        return BookFilterResponse.
                builder().
                bookNo(book.getBookNo()).
                authorEmail(book.getAuthor().getEmail()).
                authorName(book.getAuthor().getName()).
                bookType(book.getBookType()).
                bookName(book.getTitle()).
                build();
    }
}
