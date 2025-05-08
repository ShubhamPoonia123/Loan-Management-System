package com.LMS.Loan.Management.System.dto;

import com.LMS.Loan.Management.System.entity.Customer;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CustomerListDTO {

    private int status;
    private String message;
    private List <Customer> data;

    public CustomerListDTO(int status, String message, List<Customer> data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
}
