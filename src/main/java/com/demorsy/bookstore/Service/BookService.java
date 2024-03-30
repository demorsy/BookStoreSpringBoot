package com.demorsy.bookstore.Service;

import com.demorsy.bookstore.Entity.Book;
import com.demorsy.bookstore.Repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    BookRepository bookRepository;

    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public Book saveBook(Book newBook){
        return bookRepository.save(newBook);
    }

    public Book getOneBook(Long bookId){
        return bookRepository.findById(bookId).orElse(null);
    }

    public List<Book> getBooksByContainingName(String bookName){
        return bookRepository.findBooksByBookNameContaining(bookName);
    }

    public void deleteBook(Long bookId){
        bookRepository.deleteById(bookId);
    }
}
