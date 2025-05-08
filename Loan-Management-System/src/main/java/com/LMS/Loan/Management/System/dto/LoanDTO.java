package com.LMS.Loan.Management.System.dto;

import com.LMS.Loan.Management.System.entity.Loan;

public class LoanDTO {
    private int status;
    private String message;
    private Loan data;

    public LoanDTO ( int status,String message, Loan data ) {
        this.status = status;
        this.message=message;
        this.data=data;
    }
}
