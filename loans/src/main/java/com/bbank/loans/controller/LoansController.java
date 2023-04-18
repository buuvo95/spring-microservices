package com.bbank.loans.controller;


import java.util.List;
import java.util.Objects;

import com.bbank.loans.model.Customer;
import com.bbank.loans.model.Loans;
import com.bbank.loans.repository.LoansRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LoansController {

    @Autowired
    private LoansRepository loansRepository;

    @PostMapping("/myLoans")
    public List<Loans> getLoansDetails(@RequestBody Customer customer) {
        List<Loans> loans = loansRepository.findByCustomerIdOrderByStartDtDesc(customer.getCustomerId());
        if (Objects.nonNull(loans)) {
            return loans;
        } else {
            return null;
        }

    }

}
