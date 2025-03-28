package com.rafiyad.reactivespringbootcrud.repository;


import com.rafiyad.reactivespringbootcrud.entity.Customer;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class CustomerRepository {

    private static void sleepExecution(int sleepTime) {
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }

    public List<Customer> getAllCustomers(){
        return  IntStream.range(1, 100)
                .peek(CustomerRepository::sleepExecution)
                .peek(i -> System.out.println("Processing item: "+i))
                .mapToObj(i -> new Customer(i, "Customer "+i)).
                collect(Collectors.toList());

    }
}
