package org.sachin.Library_System.service.impl;

import org.sachin.Library_System.dto.request.BookCreationRequest;
import org.sachin.Library_System.dto.response.BookCreationResponse;
import org.sachin.Library_System.enums.BookFilter;
import org.sachin.Library_System.enums.Operator;
import org.sachin.Library_System.model.Author;
import org.sachin.Library_System.model.Book;
import org.sachin.Library_System.model.User;
import org.sachin.Library_System.repository.BookRepository;
import org.sachin.Library_System.service.BookFilterStratergy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookFilterFactory bookFilterFactory;

    public BookCreationResponse addBook(BookCreationRequest request) {
        // author is already present or not?
        Author authorFromDb = authorService.findAuthorInDb(request.getAuthorEmail());
//        if(authorFromDb == null){
//            authorFromDb = authorService.saveMyAuthor(Author.
//                    builder().
//                    id(UUID.randomUUID().toString()).
//                    email(request.getAuthorEmail()).name(request.getAuthorName())
//                    .build());
//        }
        Book book = request.toBook();
        if(authorFromDb == null){
            authorFromDb = Author.builder().
                    id(UUID.randomUUID().toString()).
                    email(request.getAuthorEmail()).
                    name(request.getAuthorName()).
                    build();
        }
        book.setAuthor(authorFromDb);
        book = bookRepository.save(book);
        return BookCreationResponse.
                builder().
                bookName(book.getTitle()).
                bookNo(book.getBookNo()).
                securityAmount(book.getSecurityAmount()).
                build();
    }
    //2 entities which are related to each other, manytoone relationship
    // 1 entity is getting saved, save the second one too -> CASCADE

    public List<Book> filter(BookFilter filterBy, Operator operator, String value) {
        // cases here , switch , if else
        BookFilterStratergy stratergy = bookFilterFactory.getStratergy(filterBy);
        return stratergy.getFilteredBook(operator, value);
    }

    public Book checkIfBookIsValid(String bookNo) {
        List<Book> books= bookRepository.findByBookNo(bookNo);
        if(books.isEmpty()){
            return null;
        }
        return books.get(0);
    }

    public void markBookUnavailable(Book bookFromDb, User userFromDb) {
        bookFromDb.setUser(userFromDb);
        bookRepository.save(bookFromDb);
    }
}
// collection  ?
// interfaces and classes ?
// design pattern factory
