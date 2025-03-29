package com.rafiyad.reactivespringbootcrud.service;

import com.rafiyad.reactivespringbootcrud.entity.Customer;
import com.rafiyad.reactivespringbootcrud.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Flux<Customer> loadAllCustomersStream() {
        long start = System.currentTimeMillis();
        Flux<Customer> allCustomersStream = customerRepository.getAllCustomersStream();
        long end = System.currentTimeMillis();
        System.out.println("Time taken to load all customers in stream : "+(end-start)+" ms");
        return allCustomersStream;
    }



    public List<Customer> loadAllCustomers() {
        long start = System.currentTimeMillis();
        List<Customer> customers= customerRepository.getAllCustomers();
        long end = System.currentTimeMillis();
        System.out.println("Time taken to load all customers: "+(end-start)+" ms");
        return customers;
    }

}
