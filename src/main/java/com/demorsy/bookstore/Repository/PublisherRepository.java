package com.demorsy.bookstore.Repository;

import com.demorsy.bookstore.Entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher,Long> {
}
