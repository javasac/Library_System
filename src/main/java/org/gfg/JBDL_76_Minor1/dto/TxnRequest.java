package org.gfg.JBDL_76_Minor1.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class TxnRequest {
    @NotBlank(message = "user email must not be blank")
    private String userEmail;
    @NotBlank(message = "bookNo must not be blank")
    private String bookNo;
}
