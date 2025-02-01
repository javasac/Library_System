package org.sachin.Library_System.dto.response;

import lombok.*;
import org.sachin.Library_System.enums.BookType;

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
