package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

@Controller
public class IndexController {

    @RequestMapping({"/", ""})
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/booksList", method = RequestMethod.GET)
    public String booksList(Model model) {
        // code to get books and enrich model with those books
        ArrayList<Book> books = BooksRepository.getBooks();
        model.addAttribute("books", books);
        return "booksList";
    }

    @RequestMapping(value = "/addBook", method = RequestMethod.POST)
    public String addNewBook(Book model) {
        // code to save new book
        BooksRepository.addBook(new Book(model.getBookName(),model.getIsbn(), model.getBookAuthor()));
        return "redirect:/booksList";
    }
}



