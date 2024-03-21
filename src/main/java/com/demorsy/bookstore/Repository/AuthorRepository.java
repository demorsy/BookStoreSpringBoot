package com.demorsy.bookstore.Repository;

import com.demorsy.bookstore.Entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Long> {
}
