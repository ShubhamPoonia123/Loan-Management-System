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
}
