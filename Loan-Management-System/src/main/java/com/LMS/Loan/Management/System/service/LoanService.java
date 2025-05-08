package com.LMS.Loan.Management.System.service;

import com.LMS.Loan.Management.System.entity.Customer;
import com.LMS.Loan.Management.System.entity.Loan;
import com.LMS.Loan.Management.System.repository.CustomerRepository;
import com.LMS.Loan.Management.System.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public Loan applyForLoan( Integer customerId, Loan loanRequest) {
        Customer customer = customerRepository.findById(customerId).orElse ( null );
        loanRequest.setCustomer(customer);
        loanRequest.setStatus("PENDING");

        double interest = (loanRequest.getLoanAmount() * loanRequest.getInterestRate() * loanRequest.getDurationInMonths()) / (12 * 100);
        loanRequest.setTotalInterest(interest);
        loanRequest.setTotalPayableAmount(loanRequest.getLoanAmount() + interest);

        return loanRepository.save(loanRequest);
    }

    public Loan approveLoan(Integer loanId, boolean approve) {
        Loan loan = loanRepository.findById(loanId)
                .orElseThrow(() -> new RuntimeException("Loan not found"));

        if (!loan.getStatus().equals("PENDING")) {
            throw new RuntimeException("Loan already processed");
        }

        loan.setStatus(approve ? "APPROVED" : "REJECTED");
        return loanRepository.save(loan);
    }

    public List <Loan> getLoansByCustomer( Integer customerId) {
        return loanRepository.findByCustomerId(customerId);
    }

    public Loan getLoanById(Integer id) {
        return loanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Loan not found"));
    }


    public List<Loan> getLoanHistoryByCustomer(Integer customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        return loanRepository.findByCustomer(customer);
    }

    public List<Loan> getPendingLoans() {
        return loanRepository.findByStatus("PENDING");
    }


}

