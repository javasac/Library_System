package org.sachin.Library_System.service.impl;

import org.sachin.Library_System.enums.Operator;
import org.sachin.Library_System.model.Book;
import org.sachin.Library_System.service.BookFilterStratergy;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class BookTitleFilterImpl implements BookFilterStratergy {
    @Override
    public List<Book> getFilteredBook(Operator operator, String value) {
        return List.of();
    }
}
