package com.webfluxdemo.handler;

import com.webfluxdemo.dao.CustomerDao;
import com.webfluxdemo.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerStreamHandler {
    @Autowired
    private CustomerDao customerDao;

    public Mono<ServerResponse> loadCustomerStream(ServerRequest serverRequest){
        Flux<Customer> customersStream = customerDao.getCustomersStream();

        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                //.contentType(MediaType.APPLICATION_STREAM_JSON)
                .body(customersStream,Customer.class);

    }
}
