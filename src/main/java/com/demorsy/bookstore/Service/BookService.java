package com.demorsy.bookstore.Service;

import com.demorsy.bookstore.Dto.CreateBookDto;
import com.demorsy.bookstore.Dto.ResponseBookDto;
import com.demorsy.bookstore.Entity.Book;
import com.demorsy.bookstore.Mapper.BookDtoMapper;
import com.demorsy.bookstore.Repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {
    private final BookRepository bookRepository;

    private final BookDtoMapper bookDtoMapper;

    public BookService(BookRepository bookRepository, BookDtoMapper bookDtoMapper){
        this.bookRepository = bookRepository;
        this.bookDtoMapper = bookDtoMapper;
    }

    public List<ResponseBookDto> getAllBooks(){
        return bookRepository.findAll()
                .stream()
                .map(bookDtoMapper::convertBookToDto)
                .collect(Collectors.toList());
    }

    public ResponseBookDto saveBook(CreateBookDto bookDto){
        Book newBook = bookDtoMapper.convertDtoToBook(bookDto); // Mapper
        Book savedBook = bookRepository.save(newBook);
        return bookDtoMapper.convertBookToDto(savedBook);

    }

    public ResponseBookDto getOneBook(Long bookId){
        Book foundbook =  bookRepository.findById(bookId).orElse(null);
        if(foundbook != null){
            return bookDtoMapper.convertBookToDto(foundbook);
        }else{
            return null;
        }
    }

    public List<ResponseBookDto> getBooksByContainingName(String bookName){
        return bookRepository.findBooksByBookNameContainingIgnoreCase(bookName)
                .stream()
                .map(bookDtoMapper::convertBookToDto)
                .collect(Collectors.toList());
    }

    public void deleteBook(Long bookId){
        bookRepository.deleteById(bookId);
    }
}
