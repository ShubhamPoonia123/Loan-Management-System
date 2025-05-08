package com.LMS.Loan.Management.System.dto;

import com.LMS.Loan.Management.System.entity.Repayment;

import java.util.List;

public class ReypaymentListDTO {

    private int status;
    private String message;
    private List < Repayment > data;

    public ReypaymentListDTO(int status, String message, List<Repayment> data) {
        this.status = status;
        this.message = message;
        this.data = data;
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

    public List < Repayment > getData ( ) {
        return data;
    }

    public void setData ( List < Repayment > data ) {
        this.data = data;
    }
}
