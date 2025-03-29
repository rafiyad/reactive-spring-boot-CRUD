package com.rafiyad.reactivespringbootcrud.handler;


import com.rafiyad.reactivespringbootcrud.entity.Customer;
import com.rafiyad.reactivespringbootcrud.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerHandler {

    @Autowired
    private CustomerRepository customerRepository;

    public Mono<ServerResponse> loadAllCustomersFromHandler (ServerRequest request){
        Flux<Customer> allCustomersStreamHandl=customerRepository.getAllCustomersStreamHandler();
        return ServerResponse.ok().body(allCustomersStreamHandl, Customer.class);
    }

}
