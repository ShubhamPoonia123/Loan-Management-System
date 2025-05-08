package com.LMS.Loan.Management.System.dto;

public class APIResponseDTO {

    public int status;
    public String message;

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

    public APIResponseDTO ( int status , String message) {
        this.status = status;
        this.message=message;
    }
}
