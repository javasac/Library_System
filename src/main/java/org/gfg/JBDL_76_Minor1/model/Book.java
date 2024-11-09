package org.gfg.JBDL_76_Minor1.model;

import jakarta.persistence.*;
import lombok.*;
import org.gfg.JBDL_76_Minor1.enums.BookType;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Builder
public class Book extends TimeStamps{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50)
    private String title;

    @Column(length = 20, unique = true)
    private String bookNo;

    @Enumerated
    private BookType bookType;

    @Column(nullable = false)
    private Double securityAmount;

    @ManyToOne
    @JoinColumn
    private User user;

    @ManyToOne
    @JoinColumn
    private Author author;

    @OneToMany(mappedBy = "book")
    private List<Txn> txnList;

}
// id as an single, composite key
// 1 -> a1
// 2-> a1
// many to many