package com.example.library.service;

import com.example.book_library.model.Book;

import java.util.List;

public interface BookService {
    Book getBookById(Long id);
    Book createBook(Book book);
    Book updateBook(Long id, Book book);
    void deleteBook(Long id);
    List<Book> getAllBooks();
}
