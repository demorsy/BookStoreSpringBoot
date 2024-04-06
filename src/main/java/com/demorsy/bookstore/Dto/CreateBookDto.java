package com.demorsy.bookstore.Dto;

import jakarta.validation.constraints.NotEmpty;

public record CreateBookDto(
        @NotEmpty
         String bookName,

         @NotEmpty(message = "Price cannot be null.")
         double price,
         int author_id,
         int publisher_id,
         String description


) {



}
