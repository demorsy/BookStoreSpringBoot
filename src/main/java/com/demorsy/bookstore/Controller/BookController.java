package com.demorsy.bookstore.Controller;

import com.demorsy.bookstore.Entity.Book;
import com.demorsy.bookstore.Service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {
    private BookService bookService;

    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/{bookId}")
    public Book getOneBookById(@PathVariable Long bookId){
        return bookService.getOneBook(bookId);
    }

    @PostMapping
    public Book createBook(@RequestBody Book newBook){
        return bookService.saveBook(newBook);
    }

    @GetMapping("/search/{bookName}")
    public List<Book> getBooksByContainingName(@PathVariable String bookName){
        return bookService.getBooksByContainingName(bookName);
    }

    @DeleteMapping("/{bookId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteBook(@PathVariable Long bookId){
        bookService.deleteBook(bookId);
    }
}
