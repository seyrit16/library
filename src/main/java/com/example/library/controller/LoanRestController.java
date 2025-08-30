package com.example.library.controller;

import com.example.library.dto.LoanDto;
import com.example.library.service.LoanService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/loans")
public class LoanRestController {
    private final LoanService loanService;

    public LoanRestController(LoanService loanService) {
        this.loanService = loanService;
    }

    @GetMapping
    public List<LoanDto> getAllActiveLoans() {
        return loanService.getAllActiveLoans();
    }
}
