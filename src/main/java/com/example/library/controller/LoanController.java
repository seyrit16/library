package com.example.library.controller;

import com.example.library.model.Loan;
import com.example.library.service.BookService;
import com.example.library.service.ClientService;
import com.example.library.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/loans")
public class LoanController {

    private final LoanService loanService;
    private final BookService bookService;
    private final ClientService clientService;

    @Autowired
    public LoanController(LoanService loanService, BookService bookService, ClientService clientService) {
        this.loanService = loanService;
        this.bookService = bookService;
        this.clientService = clientService;
    }

    @GetMapping
    public String listLoans(Model model){
        model.addAttribute("loans", loanService.getAllLoans());
        return "loans/list";
    }

    @GetMapping("/new")
    public String newLoanForm(Model model){
        model.addAttribute("loan", new Loan());
        model.addAttribute("clients", clientService.getAllClients());
        model.addAttribute("books", bookService.getAllBooks());
        return "loans/form";
    }

    @PostMapping("/new")
    public String createLoan(@ModelAttribute Loan loan){
        loanService.createLoan(loan);
        return  "redirect:/loans";
    }

    @GetMapping("/delete/{id}")
    public String deleteLoan(@PathVariable Long id){
        loanService.deleteLoan(id);
        return "redirect:/loans";
    }
}
