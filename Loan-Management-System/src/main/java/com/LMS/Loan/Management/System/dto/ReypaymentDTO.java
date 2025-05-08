package com.LMS.Loan.Management.System.dto;

import com.LMS.Loan.Management.System.entity.Repayment;

public class ReypaymentDTO {

    private int status;
    private String message;
    private Repayment data;

    public ReypaymentDTO ( int status,String message, Repayment data ) {
        this.status = status;
        this.message=message;
        this.data=data;
    }
}
