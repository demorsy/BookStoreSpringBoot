package com.demorsy.bookstore.Dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record CreateBookDto(
         @NotEmpty
         String bookName,

         @NotNull(message = "Price cannot be null.")
         double price,
         int author_id,
         int publisher_id,
         String description


) {



}
