package com.example.demo;

import java.util.ArrayList;

class BooksRepository {
    private static ArrayList<Book> books = new ArrayList<Book>();

    public static ArrayList<Book> getBooks() {
        return books;
    }

    public static void addBook(Book book){
      books.add(book);
    }
}
