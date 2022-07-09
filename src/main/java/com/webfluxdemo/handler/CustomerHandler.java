package com.webfluxdemo.handler;

import com.webfluxdemo.dao.CustomerDao;
import com.webfluxdemo.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerHandler {
    @Autowired
    private CustomerDao customerDao;

    public Mono<ServerResponse> loadCustomers(ServerRequest serverRequest){
        Flux<Customer> customerList = customerDao.getCustomerList();

        return ServerResponse.ok().body(customerList,Customer.class);

    }

    public Mono<ServerResponse> findCustomerById(ServerRequest serverRequest){
        Integer customerId = Integer.parseInt(serverRequest.pathVariable("input"));

        //customerDao.getCustomerList().filter(i -> i.getId() == customerId).take(1).single();
        Mono<Customer> customerMono = customerDao.getCustomerList()
                .filter(i -> i.getId() == customerId)
                .next();

        return ServerResponse.ok().body(customerMono,Customer.class);
    }

    public Mono<ServerResponse> saveCustomer(ServerRequest serverRequest){
        Mono<Customer> customerMono = serverRequest.bodyToMono(Customer.class);

        Mono<String> stringMono = customerMono.map(t -> t.getId() + ": " + t.getName());

        return ServerResponse.ok().body(stringMono,String.class);
    }


}
