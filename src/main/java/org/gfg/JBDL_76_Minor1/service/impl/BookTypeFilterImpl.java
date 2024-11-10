package org.gfg.JBDL_76_Minor1.service.impl;

import org.gfg.JBDL_76_Minor1.dto.BookFilterResponse;
import org.gfg.JBDL_76_Minor1.enums.Operator;
import org.gfg.JBDL_76_Minor1.model.Book;
import org.gfg.JBDL_76_Minor1.service.BookFilterStratergy;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class BookTypeFilterImpl implements BookFilterStratergy {
    @Override
    public List<Book> getFilteredBook(Operator operator, String value) {
        return List.of();
    }
}
