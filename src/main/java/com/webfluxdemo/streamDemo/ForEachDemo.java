package com.webfluxdemo.streamDemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class ForEachDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("arif");
        list.add("asif");
        list.add("alif");
        list.add("akif");

        for(String s : list){
            System.out.println(s);
            System.out.println("---");
        }

        //use of forEach() as stream api:
        list.stream().forEach(t-> System.out.println(t));


        Map<Integer, String> map = new HashMap<>();

        map.put(1,"a");
        map.put(2,"b");
        map.put(3,"c");
        map.put(4,"d");

        map.forEach((key,value)-> System.out.println(key+" : "+value));//for this we can not use the pipe line method of the stream class

        //to use the pipeline methods we need to add entrySet()
        map.entrySet().stream().forEach(t-> System.out.println(t));

        //how forEach works internally
        Consumer<String> consumer = t-> System.out.println(t);
        for(String s : list){
            consumer.accept(s);
        }
    }

}
