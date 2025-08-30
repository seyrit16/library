package com.example.library.service.impl;

import com.example.library.dto.LoanDto;
import com.example.library.model.Loan;
import com.example.library.repository.LoanRepository;
import com.example.library.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoanServiceImpl implements LoanService {

    private final LoanRepository loanRepository;

    @Autowired
    public LoanServiceImpl(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @Override
    public Loan createLoan(Loan loan) {
        return loanRepository.save(loan);
    }

    @Override
    public void deleteLoan(Long id) {
        loanRepository.deleteById(id);
    }

    @Override
    public Loan getLoanById(Long id) {
        return loanRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Loan not found with id" + id));
    }

    @Override
    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }

    @Override
    public List<LoanDto> getAllActiveLoans() {
        return loanRepository.findAll().stream()
                .map(loan -> LoanDto.builder()
                        .clientSurname(loan.getClient().getSurname())
                        .clientName(loan.getClient().getName())
                        .clientPatronymic(loan.getClient().getPatronymic())
                        .clientBirthDate(loan.getClient().getBirthDate())
                        .bookTitle(loan.getBook().getTitle())
                        .bookAuthor(loan.getBook().getAuthor())
                        .bookIsbn(loan.getBook().getIsbn())
                        .loanDate(loan.getLoanDate())
                        .build()
                ).collect(Collectors.toList());
    }
}
