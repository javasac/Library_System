package org.gfg.JBDL_76_Minor1.controller;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.gfg.JBDL_76_Minor1.dto.GenericReturnClass;
import org.gfg.JBDL_76_Minor1.dto.request.BookCreationRequest;
import org.gfg.JBDL_76_Minor1.dto.response.BookCreationResponse;
import org.gfg.JBDL_76_Minor1.enums.BookFilter;
import org.gfg.JBDL_76_Minor1.enums.Operator;
import org.gfg.JBDL_76_Minor1.model.Book;
import org.gfg.JBDL_76_Minor1.service.impl.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/addBook")
    public ResponseEntity<GenericReturnClass> addBook(@RequestBody @Validated BookCreationRequest request){
        BookCreationResponse response = bookService.addBook(request);
        GenericReturnClass returnObject = GenericReturnClass.builder().data(response).build();
        if(response != null){
            returnObject.setCode(0);
            returnObject.setMsg("Its successful");
        }else{
            returnObject.setCode(1);
            returnObject.setMsg("Its failed");
        }
        return new ResponseEntity<>(returnObject, HttpStatus.OK);
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