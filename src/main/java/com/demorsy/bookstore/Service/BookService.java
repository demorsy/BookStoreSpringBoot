package com.demorsy.bookstore.Service;

import com.demorsy.bookstore.Dto.CreateBookDto;
import com.demorsy.bookstore.Entity.Author;
import com.demorsy.bookstore.Entity.Book;
import com.demorsy.bookstore.Entity.Publisher;
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

    public Book saveBook(CreateBookDto bookDto){
        Book newBook = new Book();
        newBook.setBookName(bookDto.bookName());
        newBook.setPrice(bookDto.price());

        Author author = new Author();
        author.setId((long) bookDto.author_id());
        newBook.setAuthor(author);

        Publisher publisher = new Publisher();
        publisher.setId((long) bookDto.publisher_id());
        newBook.setPublisher(publisher);

        newBook.setDescription(bookDto.description());

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
