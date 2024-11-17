package org.gfg.JBDL_76_Minor1.dto.response;

import lombok.*;
import org.gfg.JBDL_76_Minor1.enums.BookType;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class BookFilterResponse {
    private String bookNo;
    private String bookName;
    private BookType bookType;
    private String authorName;
    private String authorEmail;
}
