package org.gfg.JBDL_76_Minor1.model;

import jakarta.persistence.*;
import lombok.*;
import org.gfg.JBDL_76_Minor1.enums.UserStatus;
import org.gfg.JBDL_76_Minor1.enums.UserType;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "\"USER\"")
public class User extends TimeStamps{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50)
    private String name;

    @Column(unique = true, length =15)
    private String phoneNo;

    @Column(nullable = false, unique = true, length =50)
    private String email;

    private String address;

    @Enumerated
    private UserStatus userStatus;

    @Enumerated
    private UserType userType;

    @Transient
    private String temp;

    @OneToMany(mappedBy = "user")
    private List<Book> bookList;

    @OneToMany(mappedBy = "user")
    private List<Txn> txnList;

}
