package com.demorsy.bookstore.Service;

import com.demorsy.bookstore.Dto.CreateBookDto;
import com.demorsy.bookstore.Dto.ResponseBookDto;
import com.demorsy.bookstore.Entity.Author;
import com.demorsy.bookstore.Entity.Book;
import com.demorsy.bookstore.Entity.Publisher;
import com.demorsy.bookstore.Mapper.BookDtoMapper;
import com.demorsy.bookstore.Repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BookServiceTest {

    @InjectMocks
    private BookService bookService;
    @Mock
    private BookDtoMapper  bookDtoMapper;
    @Mock
    private BookRepository bookRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void shouldSuccessfullySaveBook(){

        //Given
        CreateBookDto createBookDto = new CreateBookDto(
                "Test Book",
                15.00,
                1,
                1,
                "test description lorem ipsum"
        );

        Author author = new Author();
        author.setId(1L);
        Publisher publisher = new Publisher();
        publisher.setId(1L);

        Book book = new Book();
        book.setBookName("Test Book");
        book.setPrice(15.00);
        book.setDescription("test description lorem ipsum");
        book.setAuthor(author);
        book.setPublisher(publisher);

        Book savedBook = new Book();
        savedBook.setBookName("Test Book");
        savedBook.setPrice(15.00);
        savedBook.setDescription("test description lorem ipsum");
        savedBook.setAuthor(author);
        savedBook.setPublisher(publisher);
        savedBook.setId(1L);


        // Mock the calls
        when(bookDtoMapper.convertDtoToBook(createBookDto)).thenReturn(book);
        when(bookRepository.save(book)).thenReturn(savedBook);
        when(bookDtoMapper.convertBookToDto(savedBook)).thenReturn(new ResponseBookDto(
           1L,
           "Test Book",
           15.00,
           1L,
           1L,
           "test description lorem ipsum"
        ));

        //When
        ResponseBookDto responseBookDto = bookService.saveBook(createBookDto);

        //Then
        assertEquals(createBookDto.bookName(), responseBookDto.bookName());
        assertEquals(createBookDto.price(), responseBookDto.price());
        assertEquals(createBookDto.author_id(),responseBookDto.author_id());
        assertEquals(createBookDto.publisher_id(), responseBookDto.publisher_id());
        assertEquals(createBookDto.description(), responseBookDto.description());

        verify(bookDtoMapper,times(1)).convertDtoToBook(createBookDto);
        verify(bookRepository,times(1)).save(book);
        verify(bookDtoMapper,times(1)).convertBookToDto(savedBook);
    }

    @Test
    public void shouldReturnAllBooks(){
        List<Book> books = new ArrayList<>();

        Author author = new Author();
        author.setId(1L);
        Publisher publisher = new Publisher();
        publisher.setId(1L);

        Book book = new Book();
        book.setBookName("Test Book");
        book.setPrice(15.00);
        book.setDescription("test description lorem ipsum");
        book.setAuthor(author);
        book.setPublisher(publisher);
        books.add(book);

        // Mock the calls
        when(bookRepository.findAll()).thenReturn(books);
        when(bookDtoMapper.convertBookToDto(any(Book.class)))
                .thenReturn(new ResponseBookDto(
                        1L,
                        "Test Book",
                        15.00,
                        1L,
                        1L,
                        "test description lorem ipsum"
                ));

        //Where
        List<ResponseBookDto> responseBookDtos = bookService.getAllBooks();

        //Then
        assertEquals(books.size(),responseBookDtos.size());
        verify(bookRepository,times(1)).findAll();
    }

    @Test
    public void shouldReturnBookById(){
        // 7:28:16
        Long bookId = 1L;

        Author author = new Author();
        author.setId(1L);
        Publisher publisher = new Publisher();
        publisher.setId(1L);

        Book book = new Book();
        book.setBookName("Test book");

        book.setPrice(15.00);
        book.setDescription("test description lorem ipsum");
        book.setAuthor(author);
        book.setPublisher(publisher);

        //Mock calls
        when(bookRepository.findById(bookId)).thenReturn(Optional.of(book));
        when(bookDtoMapper.convertBookToDto(any(Book.class)))
                .thenReturn(new ResponseBookDto(
                        1L,
                        "Test book",
                        15.00,
                        1L,
                        1L,
                        "test description lorem ipsum"
                ));
        //When
        ResponseBookDto bookDto = bookService.getOneBook(bookId);

        //Then
        assertEquals(bookDto.bookName(),book.getBookName());
        assertEquals(bookDto.price(), book.getPrice());
        assertEquals(bookDto.author_id(),book.getAuthor().getId());
        assertEquals(bookDto.publisher_id(),book.getPublisher().getId());
        assertEquals(bookDto.description(),book.getDescription());

        verify(bookRepository,times(1)).findById(bookId);

    }
}