package com.pronix.service;

import com.pronix.entity.Book;
import com.pronix.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public void saveBook(Book book) {
        bookRepository.save(book);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public void updateBook(Long id, Book newBook) {
        Book book = bookRepository.findById(id).orElse(null);
        if(book != null){
            book.setBookName(newBook.getBookName());
            book.setBookAuthor(newBook.getBookAuthor());
            book.setBookPrice(newBook.getBookPrice());
            book.setIsbn(newBook.getIsbn());
            bookRepository.save(book);
        } else {
            throw new IllegalArgumentException("Invalid Input");
        }
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

}
