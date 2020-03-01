package org.sda.java25.library.rest;

import org.sda.java25.library.model.Book;
import org.sda.java25.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookRestController {

    private BookService bookService;

    @Autowired
    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = "/api/books", method = RequestMethod.GET)
    public List<Book> listOfBooks(){
        return bookService.findAll();
    }

    @RequestMapping(value = "/api/books", method=RequestMethod.POST)
    public void addBook(@RequestBody Book book){
        bookService.save(book);
    }

    @RequestMapping(value = "/api/books/{id}", method = RequestMethod.GET)
    public Book getBookById(@RequestBody Long id){
        return bookService.findById(id);
    }
}
