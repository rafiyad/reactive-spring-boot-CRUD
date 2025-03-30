package com.rafiyad.reactivespringbootcrud.handler;


import com.rafiyad.reactivespringbootcrud.entity.Customer;
import com.rafiyad.reactivespringbootcrud.repository.CustomerRepositoryForInMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service

public class CustomerStreamHandler {
    @Autowired
    private CustomerRepositoryForInMemory customerRepositoryForInMemory;



    public Mono<ServerResponse> loadAllCustomersFromStreamHandler(ServerRequest request){
        Flux<Customer> customerStreamFluxHandler = customerRepositoryForInMemory.getAllCustomersStreamHandler();
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(customerStreamFluxHandler, Customer.class);
    }
}
