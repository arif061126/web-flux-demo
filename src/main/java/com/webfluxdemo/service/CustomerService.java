package com.webfluxdemo.service;

import com.webfluxdemo.dao.CustomerDao;
import com.webfluxdemo.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerDao customerDao;

    //Traditional Approach:::::::
    public List<Customer> getAllCustomers(){
        long start = System.currentTimeMillis();
        List<Customer> customers = customerDao.getCustomers();
        long end = System.currentTimeMillis();
        System.out.println("total execution time: "+(end-start));
        return customers;
    }

    //for reactive programming::::::::::::
    public Flux<Customer> getAllCustomersStream(){
        long start = System.currentTimeMillis();
        Flux<Customer> customers = customerDao.getCustomersStream();
        long end = System.currentTimeMillis();
        System.out.println("total execution time: "+(end-start));
        return customers;
    }

}
