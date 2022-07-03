package com.webfluxdemo.functionalInterfaceDemo;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class BiConsumerDemo implements BiConsumer<String,Integer> {
    //Traditional approach:::::
    @Override
    public void accept(String s, Integer i) {
        System.out.println("This is for string: "+ s +" and this is for integer: "+i);
    }

    public static void main(String[] args) {
        BiConsumer biConsumer = new BiConsumerDemo();

        System.out.println(":::::Traditional approach:::::");

        biConsumer.accept("arif",100);

        System.out.println("########Annonymous Implementaion#######");

        BiConsumer<String, Integer> biConsumer1 = new BiConsumer<String, Integer>() {
            @Override
            public void accept(String s, Integer i) {
                System.out.println("This is for string: "+ s +" and this is for integer: "+i);
            }
        };
        biConsumer1.accept("asif",200);

        System.out.println("########Lambda Implementaion#######");

        BiConsumer<String,Integer> biConsumer2 = (s,i)->System.out.println("This is for string: "+ s +" and this is for integer: "+i);
        //BiConsumer handler = (s, i) -> System.out.println("This is for string: " + s + " and this is for integer: " + i);

        biConsumer2.accept("alif",300);

        System.out.println("########Real world example#######");

        Map<String, Integer> mapExample = new HashMap<>();

        mapExample.put("Arif",500);
        mapExample.put("Asif",1000);
        mapExample.put("Alif",1500);
        mapExample.put("Atif",2500);

        mapExample.forEach((k,v)->System.out.println("key: "+ k +" and value: "+v));
    }
}
