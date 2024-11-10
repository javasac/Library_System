package org.gfg.JBDL_76_Minor1.dto;

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
