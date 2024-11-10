package org.gfg.JBDL_76_Minor1.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@IdClass(AuthorCompositeKey.class)
@Builder
public class Author extends TimeStamps{

    @Id
    private String id;

    @Id
    @Column(nullable = false, unique = true, length =50)
    private String email;

    @Column(length = 50)
    private String name;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Book> bookList;
}
// i want to make a composite key here
// JsonIgnore : it is going to be ignored from my json resposne