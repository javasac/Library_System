package org.sachin.Library_System.model;

import jakarta.persistence.*;
import lombok.*;
import org.sachin.Library_System.enums.TxnStatus;

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

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn
    private Book book;


}
// t1 -> u1
// t1 -> u2 ?
