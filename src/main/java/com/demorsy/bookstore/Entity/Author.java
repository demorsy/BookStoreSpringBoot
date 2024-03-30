package com.demorsy.bookstore.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Author {

    @Id
    @SequenceGenerator(name = "author_sequence",
            sequenceName = "author_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "author_sequence")
    private Long id;

    private String firstName;
    private String secondName;

    @OneToMany(mappedBy = "author")
    private List<Book> books;

    public Author() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }
}
