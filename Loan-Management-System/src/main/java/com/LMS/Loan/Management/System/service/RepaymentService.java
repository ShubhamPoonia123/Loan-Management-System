package com.LMS.Loan.Management.System.service;


import com.LMS.Loan.Management.System.entity.Loan;
import com.LMS.Loan.Management.System.entity.Repayment;
import com.LMS.Loan.Management.System.repository.LoanRepository;
import com.LMS.Loan.Management.System.repository.RepaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class RepaymentService {

    @Autowired
    private RepaymentRepository repaymentRepository;

    @Autowired
    private LoanRepository loanRepository;

    public Repayment makeRepayment( Integer loanId, Double amount) {
        Loan loan = loanRepository.findById(loanId)
                .orElseThrow(() -> new RuntimeException("Loan not found"));

        if (!loan.getStatus().equals("APPROVED")) {
            throw new RuntimeException("Loan is not approved for repayment");
        }

        Repayment repayment = new Repayment();
        repayment.setAmount(amount);
        repayment.setLoan(loan);
        repayment.setRepaymentDate(LocalDate.now());
        repaymentRepository.save(repayment);

        double newBalance = loan.getRemainingAmount() - amount;
        loan.setRemainingAmount(Math.max(0.0, newBalance));

        if (newBalance <= 0.0) {
            loan.setStatus("REPAID");
        }

        loanRepository.save(loan);

        return repayment;
    }

    public void updateOverdueLoans() {
        List <Loan> loans = loanRepository.findAll();

        for (Loan loan : loans) {
            if (loan.getStatus().equals("APPROVED") && loan.getDueDate().isBefore(LocalDate.now()) && loan.getRemainingAmount() > 0) {
                loan.setStatus("OVERDUE");
                loanRepository.save(loan);
            }
        }
    }

    public List<Repayment> getRepaymentHistory(Integer loanId) {
        Loan loan = loanRepository.findById(loanId)
                .orElseThrow(() -> new RuntimeException("Loan not found"));
        return repaymentRepository.findByLoan(loan);
    }
}
