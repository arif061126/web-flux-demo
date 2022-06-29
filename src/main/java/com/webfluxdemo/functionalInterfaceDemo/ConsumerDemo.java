package com.webfluxdemo.functionalInterfaceDemo;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo {
    public static void main(String[] args) {
        Consumer<Integer> consumer = (c -> System.out.println("consumer :" +c));
        consumer.accept(10);

        List<Integer> list = Arrays.asList(1,2,3,4,5);

        //list.stream().forEach(consumer);
        //foreach internally use consumer functionality and internally call the accept method
        list.stream().forEach(c-> System.out.println("print : " + c));
    }
}
