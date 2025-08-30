package com.example.library.dto;

import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoanDto {

    private String clientName;
    private String clientSurname;
    private String clientPatronymic;
    private LocalDate clientBirthDate;
    private String bookTitle;
    private String bookAuthor;
    private String bookIsbn;
    private LocalDate loanDate;
}
