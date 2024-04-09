package com.demorsy.bookstore.Dto;

public record ResponseBookDto(

        Long id,
        String bookName,
        double price,
        Long author_id,
        Long publisher_id,
        String description

){
}
