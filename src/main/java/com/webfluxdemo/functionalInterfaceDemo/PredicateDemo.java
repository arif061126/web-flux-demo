package com.webfluxdemo.functionalInterfaceDemo;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateDemo {
    public static void main(String[] args) {
        /*Predicate<Integer> predicate = t -> {
            if(t%2==0){
                return true;
            }else {
                return false;
            }
        };*/
        Predicate<Integer> predicate = t -> t % 2 == 0;
        System.out.println(predicate.test(11));
        System.out.println(predicate.test(10));

        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,0);
        //foreach internally use consumer functionality and internally call the accept method
        //filter internally use predicate functionality and internally call the test method
        list.stream().filter(t->t % 2 == 1).forEach(c-> System.out.println("print : "+c));
    }
}
