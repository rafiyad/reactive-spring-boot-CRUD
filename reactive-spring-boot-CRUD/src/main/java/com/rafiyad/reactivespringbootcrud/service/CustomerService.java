package com.rafiyad.reactivespringbootcrud.service;

import com.rafiyad.reactivespringbootcrud.entity.Customer;
import com.rafiyad.reactivespringbootcrud.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> loadAllCustomers() {
        long start = System.currentTimeMillis();
        List<Customer> customers= customerRepository.getAllCustomers();
        long end = System.currentTimeMillis();
        System.out.println("Time taken to load all customers: "+(end-start)+" ms");
        return customers;
    }

}
