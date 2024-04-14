package com.demorsy.bookstore.Mapper;

import com.demorsy.bookstore.Dto.CreateBookDto;
import com.demorsy.bookstore.Dto.ResponseBookDto;
import com.demorsy.bookstore.Entity.Author;
import com.demorsy.bookstore.Entity.Book;
import com.demorsy.bookstore.Entity.Publisher;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;


class BookDtoMapperTest {

    private BookDtoMapper bookDtoMapper;

    @BeforeEach
    void setUp() {
        bookDtoMapper = new BookDtoMapper();
    }
    @Test
    public void shouldMapBookDtoToBook(){
        CreateBookDto createBookDto = new CreateBookDto(
                "Test Book",
                15.00,
                1,
                1,
                "test description lorem ipsum"
        );

        Book book = bookDtoMapper.convertDtoToBook(createBookDto);

        assertEquals(createBookDto.bookName(), book.getBookName());
        assertEquals(createBookDto.price(), book.getPrice());
        assertNotNull(book.getAuthor());
        assertEquals(createBookDto.author_id(), book.getAuthor().getId());
        assertNotNull(book.getPublisher());
        assertEquals(createBookDto.publisher_id(), book.getPublisher().getId());
        assertEquals(createBookDto.description(), book.getDescription());

    }

    @Test
    public void shouldThrowNullPointerException_whenBookDtoIsNull(){
       var exp = assertThrows(NullPointerException.class, () -> bookDtoMapper.convertDtoToBook(null));
        assertEquals("The book dto should not be null.",exp.getMessage());
    }
    @Test
    public void shouldMapBookToBookDto(){

        Publisher publisher = new Publisher();
        publisher.setName("test Publisher");
        publisher.setDescription("test description");

        Author author = new Author();
        author.setFirstName("TestFirstname");
        author.setSecondName("TestSecondName");

        Book book = new Book();
        book.setBookName("Test Name");
        book.setPrice(32.99);
        book.setAuthor(author);
        book.setPublisher(publisher);
        book.setDescription("Test description");

        ResponseBookDto responseBookDto = bookDtoMapper.convertBookToDto(book);
        assertEquals(responseBookDto.bookName(),book.getBookName());
        assertEquals(responseBookDto.price(),book.getPrice());
        //assertNotNull(responseBookDto.author_id());
        //assertEquals(responseBookDto.author_id(), book.getAuthor().getId());
        //assertNotNull(responseBookDto.publisher_id());
        //assertEquals(responseBookDto.publisher_id(), book.getPublisher().getId());
        assertEquals(responseBookDto.description(),book.getDescription());

    }
    /*
    @BeforeAll
    static void beforeAll() {
        System.out.println("Inside the before all method");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Inside the after all method");
    }

    @BeforeEach
    void setUp() {
        System.out.println("Inside the before each method");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Inside the after each method");
    }

    @Test
    public void testMethod1(){
        System.out.println("test1");
    }

    @Test
    public void testMethod2(){
        System.out.println("test2");
    }*/

}