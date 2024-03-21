package com.demorsy.bookstore.Entity;

import jakarta.persistence.*;

@Entity
@Table()
public class Book {

    @Id
    @SequenceGenerator(name = "book_sequence",
            sequenceName = "book_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "book_sequence")
    private Long id;
    private String bookName;
    private double price;

    private String description;


    public Book() {

    }

    public Long getId(){
        return this.id;
    }
    public String getBookName() {
        return bookName;
    }

    public void setBookname(String bookname) {
        this.bookName = bookName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
