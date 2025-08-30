package com.example.library.service;

import com.example.library.dto.LoanDto;
import com.example.library.model.Loan;

import java.util.List;

public interface LoanService {
    Loan createLoan(Loan loan);

    void deleteLoan(Long id);

    Loan getLoanById(Long id);

    List<Loan> getAllLoans();

    // Специальный метод для REST-задания: получить все активные займы с данными клиента и книги
    List<LoanDto> getAllActiveLoans();
}
