package org.gfg.JBDL_76_Minor1.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Author extends TimeStamps{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50)
    private String name;

    @Column(nullable = false, unique = true, length =50)
    private String email;

    @OneToMany(mappedBy = "author")
    private List<Book> bookList;
}
