package com.rafiyad.reactivespringbootcrud.controller;


import com.rafiyad.reactivespringbootcrud.entity.Customer;
import com.rafiyad.reactivespringbootcrud.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/customers")

public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @GetMapping("/")
    public List<Customer> getAllCustomers  () {
        return customerService.loadAllCustomers();
    }


    @GetMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Customer> getAllCustomersStream  () {
        return customerService.loadAllCustomersStream();
    }

}
