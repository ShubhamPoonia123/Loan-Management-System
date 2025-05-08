package com.LMS.Loan.Management.System.repository;

import com.LMS.Loan.Management.System.entity.Loan;
import com.LMS.Loan.Management.System.entity.Repayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepaymentRepository extends JpaRepository< Repayment,Integer > {
    List< Repayment> findByLoan ( Loan loan );
}
