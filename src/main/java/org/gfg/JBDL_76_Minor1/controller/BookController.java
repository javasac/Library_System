package org.gfg.JBDL_76_Minor1.controller;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.gfg.JBDL_76_Minor1.dto.BookCreationRequest;
import org.gfg.JBDL_76_Minor1.dto.BookCreationResponse;
import org.gfg.JBDL_76_Minor1.dto.BookFilterResponse;
import org.gfg.JBDL_76_Minor1.enums.BookFilter;
import org.gfg.JBDL_76_Minor1.enums.Operator;
import org.gfg.JBDL_76_Minor1.model.Book;
import org.gfg.JBDL_76_Minor1.model.User;
import org.gfg.JBDL_76_Minor1.service.impl.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@Validated
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/addBook")
    public BookCreationResponse addStudent(@RequestBody BookCreationRequest request){
        return bookService.addBook(request);
    }


    @GetMapping("/filter")
    public List<Book> filteredUser(@NotNull(message = "filterby must not be null") @RequestParam("filterBy") BookFilter filterBy,
                                   @NotNull(message = "operator must not be null")  @RequestParam("operator") Operator operator,
                                   @NotBlank(message = "value must not be blank")  @RequestParam("value") String value
    ) {
        return bookService.filter(filterBy, operator, value);
    }

}

// c: create a book
// filter: student
// update, delete