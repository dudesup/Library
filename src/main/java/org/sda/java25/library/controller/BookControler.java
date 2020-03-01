package org.sda.java25.library.controller;

import org.sda.java25.library.model.Book;
import org.sda.java25.library.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

@Controller
public class BookControler {

    private static final Logger log = LoggerFactory.getLogger(BookControler.class);

    private BookService bookService;

    @Autowired
    public BookControler(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = "/addBook1", method = RequestMethod.POST)
    public String addBook(HttpServletRequest req) {

        String title = req.getParameter("title");
        String author = req.getParameter("author");
        String price = req.getParameter("price");

        Book book = new Book(title, author, price);
        return "";
    }

    @RequestMapping(value = "addBook2", method = RequestMethod.POST)
    public String addBook2(@ModelAttribute Book book) {
        bookService.save(book);

        bookService.findAll().forEach(book1 -> log.info(book1.getTitle()));
        return "addBookConfirmation";
    }

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public String showAllBooks(Model model){
        model.addAttribute("books", bookService.findAll());
        return "booksPage";
    }
}
