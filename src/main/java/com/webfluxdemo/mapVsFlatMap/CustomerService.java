package com.webfluxdemo.mapVsFlatMap;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerService {
    public static void main(String[] args) {
        List<Customer> customerList = CustomerDAO.getCustomers();
        System.out.println(customerList);

        //List of customer (mapping)--> convert to list of String : known as data transformation
        //mapping: c->c.getEmail() --->one to one mapping
        List<String> emails = customerList.stream().map(c -> c.getEmail()).collect(Collectors.toList());

        System.out.println("list of emails : "+emails);


        List<List<String>> listOfPhone = customerList.stream().map(c -> c.getPhoneNumbers()).collect(Collectors.toList());
        System.out.println(listOfPhone);


        //c -> c.getPhoneNumbers() : one to many mapping--->flattering
        //play with nested list--> flattering
        //c -> c.getPhoneNumbers(): stream
        //c -> c.getPhoneNumbers().stream() : stream of stream
        List<String> phones = customerList
                .stream()
                .flatMap(c -> c.getPhoneNumbers().stream())
                .collect(Collectors.toList());
        System.out.println(phones);
    }
}
