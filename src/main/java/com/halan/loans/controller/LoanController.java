package com.halan.loans.controller;

import com.halan.loans.controller.dto.CustomerLoanRequest;
import com.halan.loans.controller.dto.CustomerLoanResponse;
import com.halan.loans.service.LoanService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanController {
    private final LoanService service;

    public LoanController(LoanService service) {
        this.service = service;
    }

    @PostMapping(value = "/customer-loans")
    public ResponseEntity<CustomerLoanResponse> customerLoans(@RequestBody @Valid CustomerLoanRequest request) {
        var loanResponse = service.checkLoanAvailability(request);

        return ResponseEntity.ok(loanResponse);
    }

}
