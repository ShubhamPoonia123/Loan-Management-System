package com.LMS.Loan.Management.System.repository;

import com.LMS.Loan.Management.System.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository< Customer,Integer> {
    Optional< Customer> findByEmail ( String email );
}
