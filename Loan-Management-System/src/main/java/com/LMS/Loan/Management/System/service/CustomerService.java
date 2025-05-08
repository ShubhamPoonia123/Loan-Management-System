package com.LMS.Loan.Management.System.service;

import com.LMS.Loan.Management.System.entity.Customer;
import com.LMS.Loan.Management.System.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

        @Autowired
        private CustomerRepository customerRepository;

        public Customer addCustomer( Customer customer) {
            return customerRepository.save(customer);
        }


        public Customer updateCustomer(Integer id, Customer updatedCustomer) {
            Customer customer = customerRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Customer not found"));

            customer.setName(updatedCustomer.getName());
            customer.setEmail(updatedCustomer.getEmail());
            customer.setContact(updatedCustomer.getContact());
            customer.setAddress(updatedCustomer.getAddress());

            return customerRepository.save(customer);
        }


        public Customer getCustomer(Integer id) {
            return customerRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Customer not found"));
        }
    }

