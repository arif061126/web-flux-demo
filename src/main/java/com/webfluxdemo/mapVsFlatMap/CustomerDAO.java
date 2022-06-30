package com.webfluxdemo.mapVsFlatMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomerDAO {
    public static List<Customer> getCustomers(){
        List<Customer> customers = new ArrayList<>();

        customers.add(new Customer(101,"arif","arif@email.com", Arrays.asList("1234","5678")));
        customers.add(new Customer(102,"asif","asif@email.com", Arrays.asList("234234","234123")));
        customers.add(new Customer(103,"atif","atif@email.com", Arrays.asList("546456","12312")));
        customers.add(new Customer(104,"alif","alif@email.com", Arrays.asList("4545","67678")));

        return customers;
    }
}
