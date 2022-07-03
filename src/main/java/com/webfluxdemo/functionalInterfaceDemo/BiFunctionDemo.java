package com.webfluxdemo.functionalInterfaceDemo;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BiFunctionDemo implements BiFunction<List<Integer>, List<Integer>, List<Integer>> {
    public static void main(String[] args) {

        BiFunction biFunction = new BiFunctionDemo();

        List<Integer> list1 = Arrays.asList(1,2,6,7,5);
        List<Integer> list2 = Arrays.asList(4,5,7,8,9);

        System.out.println("########Traditional approach#######");

        System.out.println("Traditional approach: "+biFunction.apply(list1,list2));

        System.out.println("########Annonymous Implementaion#######");

        BiFunction<List<Integer>, List<Integer>, List<Integer>> biFunction1 =
                new BiFunction<List<Integer>, List<Integer>, List<Integer>>() {
            @Override
            public List<Integer> apply(List<Integer> integers, List<Integer> integers2) {
                return Stream.of(list1,list2)
                        .flatMap(List::stream)
                        //.flatMap(i->i.stream())
                        .distinct()
                        .collect(Collectors.toList());
            }
        };

        System.out.println("Annonymous Implementaion: "+biFunction1.apply(list1,list2));

        System.out.println("########Lambda Implementaion#######");

        BiFunction<List<Integer>, List<Integer>, List<Integer>> biFunction2 = (l1, l2)->
            Stream.of(l1,l2)
                    .flatMap(List::stream)
                    //.flatMap(i->i.stream())
                    .distinct()
                    .collect(Collectors.toList());

        Function<List<Integer>, List<Integer>> sortedFunction = (lists->lists
                .stream()
                .sorted()
                .collect(Collectors.toList())
        );

        System.out.println("Lambda Implementaion: "+biFunction2.apply(list1,list2));

        System.out.println("Lambda Implementaion sorted: "+biFunction2.andThen(sortedFunction).apply(list1,list2));

        System.out.println("########Real world example#######");

        Map<String, Integer> mapExample = new HashMap<>();

        mapExample.put("Arif",500);
        mapExample.put("Asif",1000);
        mapExample.put("Alif",1500);
        mapExample.put("Atif",2500);

        /*BiFunction<String,Integer,Integer> biFunction3 = (name,salary)-> salary+500;

        mapExample.replaceAll(biFunction3);*/

        mapExample.replaceAll((k,v)->v+500);

        System.out.println(mapExample);

        System.out.println(mapExample.entrySet().stream().map(m->m.getValue()).collect(Collectors.toList()));

        mapExample.entrySet().stream().map(m->m.getValue()).forEach(System.out::println);

    }

    @Override
    public List<Integer> apply(List<Integer> list1, List<Integer> list2) {
        return Stream.of(list1,list2)
                .flatMap(List::stream)
                //.flatMap(i->i.stream())
                .distinct()
                .collect(Collectors.toList());
    }
}
