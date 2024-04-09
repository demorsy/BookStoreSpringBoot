package com.demorsy.bookstore.Dto;

import jakarta.validation.constraints.*;

public record CreateBookDto(
        @NotEmpty
         String bookName,

        @DecimalMin(value = "0.10",message = "Price cannot be null or smaller than 0.10")
         double price,
         int author_id,
         int publisher_id,
         String description


) {



}
