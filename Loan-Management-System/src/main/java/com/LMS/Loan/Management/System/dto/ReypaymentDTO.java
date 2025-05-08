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

    public int getStatus ( ) {
        return status;
    }

    public void setStatus ( int status ) {
        this.status = status;
    }

    public String getMessage ( ) {
        return message;
    }

    public void setMessage ( String message ) {
        this.message = message;
    }

    public Repayment getData ( ) {
        return data;
    }

    public void setData ( Repayment data ) {
        this.data = data;
    }
}
