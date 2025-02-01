package org.sachin.Library_System.service;

import org.sachin.Library_System.enums.Operator;
import org.sachin.Library_System.model.Book;

import java.util.List;

public interface BookFilterStratergy {
    List<Book> getFilteredBook(Operator operator, String value);
}
