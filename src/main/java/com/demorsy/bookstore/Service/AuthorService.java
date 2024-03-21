package com.demorsy.bookstore.Service;

import com.demorsy.bookstore.Entity.Author;
import com.demorsy.bookstore.Repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAllAuthors(){
        return authorRepository.findAll();
    }

    public Optional<Author> getOneAuthorById(Long authorId){
        return authorRepository.findById(authorId);
    }

    public Author saveAuthor(Author newAuthor){
        return authorRepository.save(newAuthor);
    }
}
