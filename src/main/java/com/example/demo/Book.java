package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
class Book {
    private String bookName;
    private String isbn;
    private String bookAuthor;

//    public Book(String bookName, String isbn, String bookAuthor) {
//        this.bookName = bookName;
//        this.isbn = isbn;
//        this.bookAuthor = bookAuthor;
//    }
}
