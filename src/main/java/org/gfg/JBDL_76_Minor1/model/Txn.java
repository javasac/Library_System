package org.gfg.JBDL_76_Minor1.model;

import jakarta.persistence.*;
import lombok.*;
import org.gfg.JBDL_76_Minor1.enums.TxnStatus;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Builder
public class Txn extends TimeStamps {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String txnId;

    private TxnStatus txnStatus;

    private Double settlementAmount; // depending upon when u are returning the book

    private Date issuedDate;

    private Date submittedDate;

    @ManyToOne
    @JoinColumn
    private User user;

    @ManyToOne
    @JoinColumn
    private Book book;


}
// t1 -> u1
// t1 -> u2 ?
