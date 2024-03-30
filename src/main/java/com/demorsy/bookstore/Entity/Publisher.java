package com.demorsy.bookstore.Entity;

import jakarta.persistence.*;

import java.util.List;

@Table
@Entity
public class Publisher {
    @Id
    @SequenceGenerator(name = "publisher_sequence",
            sequenceName = "publisher_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "publisher_sequence")
    private Long id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "publisher")
    private List<Book> books;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
