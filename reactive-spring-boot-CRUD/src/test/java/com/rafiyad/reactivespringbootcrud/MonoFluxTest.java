package com.rafiyad.reactivespringbootcrud;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MonoFluxTest {

    @Test
    public void testMono() {
        Mono<?> mono = Mono.just("Hello Rafiyad")
                .then(Mono.error(new RuntimeException("Exception occurred")))
                .log();
        mono.subscribe(System.out::println, e -> System.out.println("Error: " + e.getMessage()));
    }

    @Test
    public void testFlux() {
        Flux <?> stringFlux = Flux.just("Spring", "Boot", "Reactive", "Microservices")
                .concatWithValues("AWS")
                .concatWith(Flux.error(new RuntimeException("Exception occurred on Flux")))
                .concatWithValues("Cloud Computation")
                .log();
        stringFlux.subscribe(System.out::println, e -> System.out.println("Error: "+ e.getMessage()));
    }

}
