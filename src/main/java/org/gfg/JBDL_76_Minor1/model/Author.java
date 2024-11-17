package org.gfg.JBDL_76_Minor1.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


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

    public void setId(String id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public List<Book> getBookList() {
        return bookList;
    }
}
// i want to make a composite key here
// JsonIgnore : it is going to be ignored from my json resposne