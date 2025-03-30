package com.rafiyad.reactivespringbootcrud.service;

import com.rafiyad.reactivespringbootcrud.dto.CustomerDto;
import com.rafiyad.reactivespringbootcrud.repository.CustomerRepository;
import com.rafiyad.reactivespringbootcrud.util.ConverterDtoToEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Flux<CustomerDto> findAllCustomers() {
        //Type casting because of postgresql, if mongo is used we can directly return
        return (Flux<CustomerDto>) customerRepository.findAll().map(ConverterDtoToEntity::entityToDto);
    }

    public Mono<CustomerDto> findCustomerById(Integer id) {
        return (Mono<CustomerDto>) customerRepository.findById(id).map(ConverterDtoToEntity::entityToDto);
    }

    // findByname and find between age can be added letter

    public Mono<CustomerDto> saveCustomer(Mono<CustomerDto> customerDto) {
        return customerDto
                .map(ConverterDtoToEntity::dtoToEntity)
                .flatMap(customerRepository::save)
                .map(ConverterDtoToEntity::entityToDto);
    }

    public Mono<CustomerDto> updateCustomer(Mono<CustomerDto> customerDto,Integer id) {
        return customerRepository.findById(id)
                .flatMap(c -> customerDto.map(ConverterDtoToEntity::dtoToEntity)
                .doOnNext(e-> e.setId(id)))
                        .flatMap(customerRepository::save)
                        .map(ConverterDtoToEntity::entityToDto);
    }

    public Mono<Void> deleteCustomer(Integer id) {
        return customerRepository.deleteById(id);
    }








    // In memory Implementations
    /*@Autowired
    private CustomerRepositoryForInMemory customerRepositoryForInMemory;

    public Flux<Customer> loadAllCustomersStream() {
        long start = System.currentTimeMillis();
        Flux<Customer> allCustomersStream = customerRepositoryForInMemory.getAllCustomersStream();
        long end = System.currentTimeMillis();
        System.out.println("Time taken to load all customers in stream : "+(end-start)+" ms");
        return allCustomersStream;
    }



    public List<Customer> loadAllCustomers() {
        long start = System.currentTimeMillis();
        List<Customer> customers= customerRepositoryForInMemory.getAllCustomers();
        long end = System.currentTimeMillis();
        System.out.println("Time taken to load all customers: "+(end-start)+" ms");
        return customers;
    }*/

}
