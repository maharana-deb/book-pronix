package com.pronix.controller;

import com.pronix.entity.Book;
import com.pronix.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping
    public void saveBook(@RequestBody Book book){
        bookService.saveBook(book);
    }

    @GetMapping
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("{id}")
    public Book getBookById(@PathVariable Long id){
        return bookService.getBookById(id);
    }

    @PutMapping("{id}")
    public void updateBook(@PathVariable Long id, @RequestBody Book book){
        if(id != null){
            bookService.saveBook(book);
        }
    }

    @DeleteMapping("{id}")
    public void deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
    }

}
