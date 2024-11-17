package org.gfg.JBDL_76_Minor1.service;

import org.gfg.JBDL_76_Minor1.enums.Operator;
import org.gfg.JBDL_76_Minor1.model.Book;

import java.util.List;

public interface BookFilterStratergy {
    List<Book> getFilteredBook(Operator operator, String value);
}
