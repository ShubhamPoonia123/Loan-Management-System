package com.LMS.Loan.Management.System.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Loan {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne (optional = false)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    private Double loanAmount;
    private Double interestRate;
    private Integer durationInMonths;
    private String purpose;
    private String status;

    private Double totalInterest;
    private Double totalPayableAmount;
    private Double paidAmount;

    private Double remainingAmount;

    private LocalDate dueDate;
    private final LocalDate applicationDate = LocalDate.now();

    public Integer getId ( ) {
        return id;
    }

    public void setId ( Integer id ) {
        this.id = id;
    }

    public Customer getCustomer ( ) {
        return customer;
    }

    public void setCustomer ( Customer customer ) {
        this.customer = customer;
    }

    public Double getLoanAmount ( ) {
        return loanAmount;
    }

    public void setLoanAmount ( Double loanAmount ) {
        this.loanAmount = loanAmount;
    }

    public Double getInterestRate ( ) {
        return interestRate;
    }

    public void setInterestRate ( Double interestRate ) {
        this.interestRate = interestRate;
    }

    public Integer getDurationInMonths ( ) {
        return durationInMonths;
    }

    public void setDurationInMonths ( Integer durationInMonths ) {
        this.durationInMonths = durationInMonths;
    }

    public String getPurpose ( ) {
        return purpose;
    }

    public void setPurpose ( String purpose ) {
        this.purpose = purpose;
    }

    public String getStatus ( ) {
        return status;
    }

    public void setStatus ( String status ) {
        this.status = status;
    }

    public Double getTotalInterest ( ) {
        return totalInterest;
    }

    public void setTotalInterest ( Double totalInterest ) {
        this.totalInterest = totalInterest;
    }

    public Double getTotalPayableAmount ( ) {
        return totalPayableAmount;
    }

    public void setTotalPayableAmount ( Double totalPayableAmount ) {
        this.totalPayableAmount = totalPayableAmount;
    }

    public Double getPaidAmount ( ) {
        return paidAmount;
    }

    public void setPaidAmount ( Double paidAmount ) {
        this.paidAmount = paidAmount;
    }

    public LocalDate getApplicationDate ( ) {
        return applicationDate;
    }

    public Double getRemainingAmount ( ) {
        return remainingAmount;
    }

    public void setRemainingAmount ( Double remainingAmount ) {
        this.remainingAmount = remainingAmount;
    }

    public LocalDate getDueDate ( ) {
        return dueDate;
    }

    public void setDueDate ( LocalDate dueDate ) {
        this.dueDate = dueDate;
    }
}

