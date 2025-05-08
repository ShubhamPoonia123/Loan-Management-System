package com.LMS.Loan.Management.System.repository;

import com.LMS.Loan.Management.System.entity.Customer;
import com.LMS.Loan.Management.System.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository< Loan,Integer > {
    List< Loan> findByCustomerId ( Integer customerId );

    List< Loan> findByCustomer ( Customer customer );

    List< Loan> findByStatus ( String pending );
}
