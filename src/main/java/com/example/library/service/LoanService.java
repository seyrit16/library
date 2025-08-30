package com.example.library.service;

import com.example.library.dto.LoanDto;
import com.example.library.model.Loan;

import java.util.List;

public interface LoanService {
    Loan createLoan(Loan loan);

    void deleteLoan(Long id);

    Loan getLoanById(Long id);

    List<Loan> getAllLoans();

    List<LoanDto> getAllActiveLoans();
}
