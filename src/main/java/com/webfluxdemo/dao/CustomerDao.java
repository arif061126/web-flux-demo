package com.webfluxdemo.dao;

import com.webfluxdemo.dto.Customer;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class CustomerDao {

    public void sleepExecution(Integer i){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Customer> getCustomers(){
        return IntStream.rangeClosed(1,50)
                .peek(this::sleepExecution) //uporer method e static use korle this er poriborte CustomerDao use korte parbo
                .peek(i-> System.out.println("process count: "+i))
                .mapToObj(i->new Customer(i,"customer"+i))
                .collect(Collectors.toList());
    }

    //for reactive programming:::::::::::::::::
    public Flux<Customer> getCustomersStream(){
        return Flux.range(1,10)
                .delayElements(Duration.ofSeconds(1))
                .doOnNext(i-> System.out.println("process count in stream flow: "+i))
                .map(i->new Customer(i,"customer"+i));
    }

    //for Functional endpoint:::::::::::::::::
    public Flux<Customer> getCustomerList(){
        return Flux.range(1,10)
                .doOnNext(i-> System.out.println("process count in stream flow: "+i))
                .map(i->new Customer(i,"customer"+i));
    }
}
