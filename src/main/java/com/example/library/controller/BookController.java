package com.example.library.controller;

import com.example.library.model.Book;
import com.example.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public String listBooks(Model model){
        model.addAttribute("books",bookService.getAllBooks());
        return "books/list";
    }

    @GetMapping("/new")
    public String newBookForm(Model model){
        model.addAttribute("book", new Book());
        return "books/form";
    }

    @PostMapping("/new")
    public String createBook(@ModelAttribute Book book){
        bookService.createBook(book);
        return "redirect:/books";
    }

    @GetMapping("/edit/{id}")
    public String editBookForm(@PathVariable Long id, Model model){
        model.addAttribute("book", bookService.getBookById(id));
        return "books/form";
    }

    @PostMapping("/edit/{id}")
    public String updateBook(@PathVariable Long id, @ModelAttribute Book book){
        bookService.updateBook(id, book);
        return "redirect:/books";
    }
}
