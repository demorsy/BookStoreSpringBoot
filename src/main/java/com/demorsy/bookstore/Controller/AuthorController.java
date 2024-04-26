package com.demorsy.bookstore.Controller;

import com.demorsy.bookstore.Entity.Author;
import com.demorsy.bookstore.Service.AuthorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<Author> getAllAuthors(){
        return authorService.getAllAuthors();
    }

    @GetMapping("/{authorId}")
    public Optional<Author> getOneAuthorById(@PathVariable Long authorId){ // fix optional
        return authorService.getOneAuthorById(authorId);
    }

    @PostMapping
    public Author createAuthor(@RequestBody Author newAuthor){
        return authorService.saveAuthor(newAuthor);
    }
}
