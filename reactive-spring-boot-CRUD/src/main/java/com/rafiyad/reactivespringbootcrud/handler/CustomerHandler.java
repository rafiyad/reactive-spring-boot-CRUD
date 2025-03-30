package com.rafiyad.reactivespringbootcrud.handler;


import com.rafiyad.reactivespringbootcrud.entity.Customer;
import com.rafiyad.reactivespringbootcrud.repository.CustomerRepositoryForInMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerHandler {

    @Autowired
    private CustomerRepositoryForInMemory customerRepositoryForInMemory;

    public Mono<ServerResponse> loadAllCustomersFromHandler (ServerRequest request){
        Flux<Customer> allCustomersStreamHandl= customerRepositoryForInMemory.getAllCustomersStreamHandler();
        return ServerResponse.ok().body(allCustomersStreamHandl, Customer.class);
    }

    public Mono<ServerResponse> findCustomerById (ServerRequest request){
        //through the request all the methods are available like header, body, queryparam etc
         int custpomerId = Integer.valueOf(request.pathVariable("input"));
        Mono<Customer> filtered = customerRepositoryForInMemory.getAllCustomersStreamHandler()
                .filter(customer -> customer.getId() == custpomerId).next();// .take(1).single() will work as same
        return ServerResponse.ok().body(filtered, Customer.class);
    }


    public Mono<ServerResponse> saveCustomer (ServerRequest request){
        //through the request all the methods are available like header, body, queryparam etc
        Mono<Customer> customerMono = request.bodyToMono(Customer.class);
        Mono<String> savedResponse = customerMono.map(repo -> repo.getId() + ": " + repo.getName());
        return ServerResponse.ok().body(savedResponse, String.class);
    }

}
