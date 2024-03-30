package com.demorsy.bookstore.Repository;

import com.demorsy.bookstore.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {

    List<Book> findBooksByBookNameContaining(String bookName);
}
