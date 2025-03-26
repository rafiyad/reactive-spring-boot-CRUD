package com.rafiyad.reactivespringbootcrud;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public class MonoFluxTest {

    @Test
    public void testMono() {
        Mono<String> mono = Mono.just("Hello Rafiyad").log();
        mono.subscribe(System.out::println);
    }

}
