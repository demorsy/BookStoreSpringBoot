package com.demorsy.bookstore.Mapper;

import com.demorsy.bookstore.Dto.CreateBookDto;
import com.demorsy.bookstore.Dto.ResponseBookDto;
import com.demorsy.bookstore.Entity.Author;
import com.demorsy.bookstore.Entity.Book;
import com.demorsy.bookstore.Entity.Publisher;
import org.springframework.stereotype.Service;

@Service
public class BookDtoMapper {

    public BookDtoMapper() {
    }

    public Book convertDtoToBook(CreateBookDto bookDto){
        if(bookDto == null){
            throw new NullPointerException("The book dto should not be null.");
        }

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

        return newBook;
    }

    public ResponseBookDto convertBookToDto(Book book){
        ResponseBookDto responseBookDto =
                new ResponseBookDto(
                        book.getId(),
                        book.getBookName(),
                        book.getPrice(),
                        book.getAuthor().getId(),
                        book.getPublisher().getId(),
                        book.getDescription()
                );


        return responseBookDto;
    }
}
