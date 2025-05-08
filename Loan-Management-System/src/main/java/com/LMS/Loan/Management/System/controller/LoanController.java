package com.LMS.Loan.Management.System.controller;

import com.LMS.Loan.Management.System.dto.APIResponseDTO;
import com.LMS.Loan.Management.System.dto.LoanDTO;
import com.LMS.Loan.Management.System.dto.LoanListDTO;
import com.LMS.Loan.Management.System.entity.Customer;
import com.LMS.Loan.Management.System.entity.Loan;
import com.LMS.Loan.Management.System.repository.CustomerRepository;
import com.LMS.Loan.Management.System.repository.LoanRepository;
import com.LMS.Loan.Management.System.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/api/loan")

public class LoanController {

    @Autowired
    private LoanService loanService;

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping ("/applyForLoan/{customerId}")
    @PreAuthorize ("hasRole('ROLE_USER')")
    public ResponseEntity< ? > applyForLoan(
            @PathVariable Integer customerId,
            @RequestBody Loan loanRequest) {

        Optional<Customer> customer = customerRepository.findById(customerId);
        if ( customer.isEmpty () ) {
            APIResponseDTO apiResponseDTO = new APIResponseDTO (404, "Customer with ID " + customerId + " not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiResponseDTO);
        }

        Loan loan = loanService.applyForLoan(customerId, loanRequest);
        return new ResponseEntity <> (new LoanDTO(201, "Loan application submitted", loan), HttpStatus.CREATED);
    }


    @GetMapping("/totalLoanOfCustomer/{customerId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    public ResponseEntity< LoanListDTO > getCustomerLoans( @PathVariable Integer customerId) {
        List<Loan> loans = loanService.getLoansByCustomer(customerId);
        return ResponseEntity.ok(new LoanListDTO (200, "Customer loans fetched", loans));
    }

    @GetMapping("/getLoanBy/{loanId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    public ResponseEntity<LoanDTO> getLoanById(@PathVariable Integer loanId) {
        Loan loan = loanService.getLoanById(loanId);
        return ResponseEntity.ok(new LoanDTO (200, "Loan fetched", loan));
    }

    @GetMapping("/customer/{customerId}/history")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    public ResponseEntity<LoanListDTO> getLoanHistoryByCustomer(@PathVariable Integer customerId) {
        List<Loan> history = loanService.getLoanHistoryByCustomer(customerId);
        return ResponseEntity.ok(new LoanListDTO (200, "All Loan history ", history));
    }

    @GetMapping("/pendingLoans")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<LoanListDTO> getPendingLoans() {
        List<Loan> pendingLoans = loanService.getPendingLoans();
        return ResponseEntity.ok(new LoanListDTO (200, "All Pending loans ", pendingLoans));
    }

}
