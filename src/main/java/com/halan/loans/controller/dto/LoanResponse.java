package com.halan.loans.controller.dto;

import com.halan.loans.domain.LoanType;

public record LoanResponse(
        LoanType loanType,
        Double interestRate) {
}
