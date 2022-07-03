package com.webfluxdemo.streamExceeptionHandling;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class StreamExceptionHandling {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("10", "20", "30", "xyz");
        //System.out.println(list);

       /* List<Integer> integerList = list.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());

        System.out.println(integerList);*/

        //list.forEach(s-> System.out.println(Integer.parseInt(s)));//give number format exception::::

        //:::::traditional way of handling exception:::::
        System.out.println(":::::traditional way of handling exception:::::");
        list.forEach(s-> {
            try {
                System.out.println(Integer.parseInt(s));
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        });

        //:::::approach 2 of handling exception:::::
        System.out.println(":::::approach 2 of handling exception:::::");
        list.forEach(StreamExceptionHandling::printList);

        //:::::approach 3 of handling exception:::::
        System.out.println(":::::approach 3 of handling exception:::::");
        list.forEach(handleExceptionIfAny(s -> System.out.println(Integer.parseInt(s))));

        //:::::approach 3 of handling exception:::::
        System.out.println(":::::approach 4 of handling exception Generic way:::::");
        list.forEach(handleGenericException(s -> System.out.println(Integer.parseInt(s)),NumberFormatException.class));

        List<Integer> list2 = Arrays.asList(1,0);
        list2.forEach(handleGenericException(s-> System.out.println(10/s),ArithmeticException.class));

        List<Integer> list3 = Arrays.asList(10,20);
        list3.forEach(i-> {
            try {
                Thread.sleep(i);
                System.out.println(i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

    }

    public static void printList(String s){
        try {
            System.out.println(Integer.parseInt(s));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static Consumer<String> handleExceptionIfAny(Consumer<String> input){
        return object->{
            try {
                input.accept(object);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        };
    }

    public static <Target, ExceptionObject extends Exception> Consumer<Target> handleGenericException(
            Consumer<Target> targetConsumer, Class<ExceptionObject> exceptionObjectClass){
        return object->{
            try {
                targetConsumer.accept(object);
            }catch (Exception e){
                try {
                    ExceptionObject exceptionObject = exceptionObjectClass.cast(e);
                    System.out.println(e.getMessage());
                }catch (ClassCastException classCastException){
                    throw classCastException;
                }
            }
        };
    }
}
