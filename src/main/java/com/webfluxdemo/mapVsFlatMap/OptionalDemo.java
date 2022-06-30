package com.webfluxdemo.mapVsFlatMap;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalDemo {

    public static Customer getCustomerByEmail(String email){
        List<Customer> customers = CustomerDAO.getCustomers();
        return customers
                .stream()
                .filter(customer -> customer.getEmail().equals(email))
                .findAny()
                .orElseGet(()->new Customer());
    }

    public static void main(String[] args) {
        Customer customer = new Customer(101, "arif", null, Arrays.asList("123","456"));

        Optional<Object> optional = Optional.empty();
        System.out.println(optional);

        //if we are sure to get some not null values-->then go for this
        /*Optional<String> optionalOf = Optional.of(customer.getEmail());
        System.out.println(optionalOf);*/

        //if we are not sure to get some not null values or null values-->then go for this
        Optional<String> optionalOfNullable = Optional.ofNullable(customer.getEmail());
        /*System.out.println(optionalOfNullable.get());*/
        if(optionalOfNullable.isPresent()){
            System.out.println(optionalOfNullable.get());
        }

        System.out.println(optionalOfNullable.orElse("ass"));
        //System.out.println(optionalOfNullable.orElseThrow(()->new IllegalArgumentException("no email present")));

        System.out.println(optionalOfNullable.map(e->e.toUpperCase()).orElseGet(()->"someemail"));

        System.out.println(getCustomerByEmail("arif@email.com"));;

    }
}
