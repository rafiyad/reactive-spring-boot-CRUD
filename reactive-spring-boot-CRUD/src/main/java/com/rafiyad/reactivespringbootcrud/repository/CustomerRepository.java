package com.rafiyad.reactivespringbootcrud.repository;

import com.rafiyad.reactivespringbootcrud.entity.Customer;


import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;


@Repository
// extends ReactiveMongoRepository for mongoDb usually JpaRepository

public interface CustomerRepository extends ReactiveCrudRepository<Customer, Integer> {


}
