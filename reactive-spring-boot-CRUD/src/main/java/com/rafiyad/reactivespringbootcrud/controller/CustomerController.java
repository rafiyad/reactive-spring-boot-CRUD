package com.rafiyad.reactivespringbootcrud.controller;


import com.rafiyad.reactivespringbootcrud.dto.CustomerDto;
import com.rafiyad.reactivespringbootcrud.entity.Customer;
import com.rafiyad.reactivespringbootcrud.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("api/v1/customer")

public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @GetMapping("/all")
    public Flux<CustomerDto> getAllCustomers(){
        return customerService.findAllCustomers();
    }

    @GetMapping("{id}")
    public Mono<CustomerDto> getCustomer(@PathVariable Integer id) {
        return customerService.findCustomerById(id);
    }

    @PostMapping("/save")
    public Mono<CustomerDto> saveCustomer(@RequestBody Mono<CustomerDto> customerDto) {
        return customerService.saveCustomer(customerDto);
    }

    @PutMapping("/update/{id}")
    public Mono<CustomerDto> updateCustomer(@RequestBody Mono<CustomerDto> customerDto, @PathVariable Integer id) {
        return customerService.updateCustomer(customerDto,id);
    }

    @DeleteMapping("/delete/{id}")
    public Mono<Void> deleteCustomer(@PathVariable Integer id) {
        return customerService.deleteCustomer(id);
    }


    //other methods like by name and age





    // In memory controller if the methods are showing red uncomment the methods in service class if want to use
    /*
    @GetMapping("/")
    public List<Customer> getAllCustomers  () {
        return customerService.loadAllCustomers();
    }


    @GetMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Customer> getAllCustomersStream  () {
        return customerService.loadAllCustomersStream();
    }*/

}
