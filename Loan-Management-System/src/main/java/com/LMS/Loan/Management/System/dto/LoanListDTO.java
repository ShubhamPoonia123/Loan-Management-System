package com.LMS.Loan.Management.System.dto;

import com.LMS.Loan.Management.System.entity.Loan;

import java.util.List;

public class LoanListDTO {

    private int status;
    private String message;
    private List<Loan> data;

    public LoanListDTO ( int status,String message, List<Loan> data ) {
        this.status = status;
        this.message=message;
        this.data=data;
    }

    public int getStatus ( ) {
        return status;
    }

    public String getMessage ( ) {
        return message;
    }

    public void setMessage ( String message ) {
        this.message = message;
    }

    public void setStatus ( int status ) {
        this.status = status;
    }

    public List < Loan > getData ( ) {
        return data;
    }

    public void setData ( List < Loan > data ) {
        this.data = data;
    }
}
