package com.demorsy.bookstore.Controller;

import com.demorsy.bookstore.Dto.CreateBookDto;
import com.demorsy.bookstore.Entity.Book;
import com.demorsy.bookstore.Service.BookService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
    public Book createBook(@Valid @RequestBody CreateBookDto newBook){
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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumantNotValidException(
            MethodArgumentNotValidException exp
    ){
        var errors = new HashMap<String, String>();
        exp.getBindingResult().getAllErrors()
        .forEach(error -> {
            var fieldName = ((FieldError) error).getField();
            var errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
