package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Service
@RequiredArgsConstructor
class BooksRepository {
    private final EntityManager entityManager;
//    private static ArrayList<Book> books = new ArrayList<Book>();

    @Transactional
    public List<Book> getBooks() {
        return entityManager.createQuery("FROM Book", Book.class).getResultList();
    }

    @Transactional
    public Book addBook(Book book){
        Book bookEntity = new Book();
        bookEntity.setBookName(book.getBookName());
        bookEntity.setIsbn(book.getIsbn());
        bookEntity.setBookAuthor(book.getBookAuthor());

        return entityManager.merge(bookEntity);
    }
}
