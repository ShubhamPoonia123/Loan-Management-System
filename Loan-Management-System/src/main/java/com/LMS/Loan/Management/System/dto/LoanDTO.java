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

    public Loan getData ( ) {
        return data;
    }

    public void setData ( Loan data ) {
        this.data = data;
    }
}
