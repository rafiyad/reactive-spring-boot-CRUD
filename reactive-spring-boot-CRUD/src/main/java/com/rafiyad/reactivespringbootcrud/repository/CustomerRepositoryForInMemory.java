package com.rafiyad.reactivespringbootcrud.repository;


import com.rafiyad.reactivespringbootcrud.entity.Customer;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class CustomerRepositoryForInMemory {

    private static void sleepExecution(int sleepTime) {
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }

    //Reactive style
    public Flux<Customer> getAllCustomersStream(){
        return Flux.range(1,20)
                .delayElements(Duration.ofSeconds(1))
                .doOnNext(i -> System.out.println("Processing item in stream : "+i))
                .map(i -> new Customer(i, "Customer "+i));
    }


    public Flux<Customer> getAllCustomersStreamHandler(){
        return Flux.range(1,30)
                .delayElements(Duration.ofMillis(500))
                .doOnNext(i -> System.out.println("Processing item in stream : "+i))
                .map(i -> new Customer(i, "Customer "+i));
    }



    //Traditional blocking approach
    public List<Customer> getAllCustomers(){
        return  IntStream.range(1, 20)
                .peek(CustomerRepositoryForInMemory::sleepExecution)
                .peek(i -> System.out.println("Processing item: "+i))
                .mapToObj(i -> new Customer(i, "Customer "+i)).
                collect(Collectors.toList());

    }
}
