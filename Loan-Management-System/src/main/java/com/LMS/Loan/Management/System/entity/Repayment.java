package com.LMS.Loan.Management.System.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Repayment {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne (optional = false)
    @JoinColumn(name = "loan_id")
    private Loan loan;

    private Double amount;

    private LocalDate repaymentDate;

    public Integer getId ( ) {
        return id;
    }

    public void setId ( Integer id ) {
        this.id = id;
    }

    public Loan getLoan ( ) {
        return loan;
    }

    public void setLoan ( Loan loan ) {
        this.loan = loan;
    }

    public Double getAmount ( ) {
        return amount;
    }

    public void setAmount ( Double amount ) {
        this.amount = amount;
    }

    public LocalDate getRepaymentDate ( ) {
        return repaymentDate;
    }

    public void setRepaymentDate ( LocalDate repaymentDate ) {
        this.repaymentDate = repaymentDate;
    }
}

