package com.LMS.Loan.Management.System.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Customer {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank (message = "Name is mandatory")
    private String name;

    @Email (message = "Invalid email format")
    @Column (unique = true)
    private String email;

    @NotBlank(message = "Contact number is required")
    @Size (min = 10, max = 12)
    private String contact;

    @NotBlank(message = "Address is required")
    private String address;

    public Integer getId ( ) {
        return id;
    }

    public void setId ( Integer id ) {
        this.id = id;
    }

    public String getName ( ) {
        return name;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    public String getEmail ( ) {
        return email;
    }

    public void setEmail ( String email ) {
        this.email = email;
    }

    public String getContact ( ) {
        return contact;
    }

    public void setContact ( String contact ) {
        this.contact = contact;
    }

    public String getAddress ( ) {
        return address;
    }

    public void setAddress ( String address ) {
        this.address = address;
    }
}
