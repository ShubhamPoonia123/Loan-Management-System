package com.LMS.Loan.Management.System.controller;

import com.LMS.Loan.Management.System.dto.APIResponseDTO;
import com.LMS.Loan.Management.System.dto.CustomerDTO;
import com.LMS.Loan.Management.System.dto.CustomerListDTO;
import com.LMS.Loan.Management.System.dto.LoanDTO;
import com.LMS.Loan.Management.System.entity.Customer;
import com.LMS.Loan.Management.System.entity.Loan;
import com.LMS.Loan.Management.System.repository.CustomerRepository;
import com.LMS.Loan.Management.System.service.CustomerService;
import com.LMS.Loan.Management.System.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/api/customers/admin")
@PreAuthorize("hasRole('ROLE_ADMIN')")

public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private LoanService loanService;

    @PostMapping("/addCustomer")
    public ResponseEntity< ? > addCustomer( @RequestBody @Valid Customer customer) {
        Optional <Customer> existing = customerRepository.findByEmail(customer.getEmail());
        if (existing.isPresent()) {
            APIResponseDTO apiResponseDTO = new APIResponseDTO(409, "Customer with email already exists");
            return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponseDTO);
            }

        Customer savedCustomer = customerService.addCustomer(customer);

        CustomerDTO response = new CustomerDTO (201, "Customer created successfully", savedCustomer);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/updateCustomerBy/{id}")
    public ResponseEntity<CustomerDTO> updateCustomer(
            @PathVariable Integer id,
            @RequestBody @Valid Customer customer) {
        Customer updatedCustomer = customerService.updateCustomer(id, customer);
        CustomerDTO response = new CustomerDTO (200, "Customer updated successfully", updatedCustomer);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getCustomerBy/{id}")
    public ResponseEntity<CustomerDTO> getCustomer(@PathVariable Integer id) {
        Customer customer = customerService.getCustomer(id);
        CustomerDTO response = new CustomerDTO (200, "Customer fetched successfully", customer);
        return ResponseEntity.ok(response);
    }


    @GetMapping("/findAllCustomer")
    public ResponseEntity< CustomerListDTO > getCustomerList( @PathVariable Integer id) {
        List <Customer> customer =  customerRepository.findAll ();
        CustomerListDTO response = new CustomerListDTO (200, "Customer fetched successfully", customer);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/approveAndRejectLoan/{loanId}")
    public ResponseEntity< LoanDTO > approveOrRejectLoan(
            @PathVariable Integer loanId,
            @RequestParam boolean approve) {
        Loan loan = loanService.approveLoan(loanId, approve);
        String msg = approve ? "Loan approved" : "Loan rejected";
        return ResponseEntity.ok(new LoanDTO(200, msg, loan));
    }
}
