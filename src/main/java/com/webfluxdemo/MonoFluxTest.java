package com.webfluxdemo;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MonoFluxTest {

    @Test
    public void testMono(){
        //Mono<String> stringMono = Mono.just("arif"); //can handle only one data type
        //Mono<String> stringMono = Mono.just("arif").log(); //to varify whether it is following reactive flow or not

        Mono<?> stringMono = Mono.just("arif")
                .then(Mono.error(new RuntimeException("runtime error occurred")))
                .log(); //to varify error

        //subscriber invoking subscribe methode
        stringMono.subscribe(System.out::println);
    }

    @Test
    public void testFlux(){
        //Flux<String> stringFlux = Flux.just("Spring", "SpringBoot", "Hibernate", "JDBC").log();
        //to test error
        Flux<String> stringFlux = Flux.just("Spring", "SpringBoot", "Hibernate", "JDBC")
                .concatWith(Flux.error(new RuntimeException("errorr occurred")))
                .concatWithValues("Sample")
                .log();

        stringFlux.subscribe(System.out::println, (e)-> System.out.println(e.getMessage()));
    }
}
