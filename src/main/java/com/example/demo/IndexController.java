package com.example.demo;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

@Controller
public class IndexController implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @RequestMapping({"/", ""})
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/booksList", method = RequestMethod.GET)
    public String booksList(Model model) {
        // code to get books and enrich model with those books
        BooksRepository booksRepository = applicationContext.getBean(BooksRepository.class);
        ArrayList<Book> books = (ArrayList<Book>)booksRepository.getBooks();
        model.addAttribute("books", books);
        return "booksList";
    }

    @RequestMapping(value = "/addBook", method = RequestMethod.POST)
    public String addNewBook(Book model) {
        // code to save new book
        BooksRepository booksRepository = applicationContext.getBean(BooksRepository.class);
        booksRepository.addBook(new Book(model.getId(), model.getBookName(),model.getIsbn(), model.getBookAuthor()));
        return "redirect:/booksList";
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}



