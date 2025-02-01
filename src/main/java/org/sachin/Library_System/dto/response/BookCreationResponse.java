package org.sachin.Library_System.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class BookCreationResponse {
    private String bookNo;
    private String bookName;
    private Double securityAmount;

}
