package com.halan.loans.service;

import com.halan.loans.controller.dto.CustomerLoanRequest;
import com.halan.loans.controller.dto.CustomerLoanResponse;
import com.halan.loans.controller.dto.LoanResponse;
import com.halan.loans.domain.Loan;
import com.halan.loans.domain.LoanType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoanService {
    public CustomerLoanResponse checkLoanAvailability(CustomerLoanRequest request) {
        var customer = request.toCustomer();
        var loan = new Loan(customer);

        List<LoanResponse> loans = new ArrayList<>();

        if (loan.isPersonalLoanAvailable()) {
            loans.add(new LoanResponse(LoanType.PERSONAL, loan.getPersonalLoanInterestRate()));
        }

        if (loan.isConsignmentAvailable()) {
            loans.add(new LoanResponse(LoanType.CONSIGNMENT, loan.getConsignmentLoanInterestRate()));
        }

        if (loan.isGuaranteedAvailable()) {
            loans.add(new LoanResponse(LoanType.GUARANTEED, loan.getGuaranteedLoanInterestRate()));
        }

        return new CustomerLoanResponse(request.name(), loans);
    }
}
