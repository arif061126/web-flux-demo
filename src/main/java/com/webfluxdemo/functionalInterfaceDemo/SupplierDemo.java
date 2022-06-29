package com.webfluxdemo.functionalInterfaceDemo;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class SupplierDemo {
    /*@Override
    public String get() {
        return "HI hI";
    }*/

    public static void main(String[] args) {
        /*SupplierDemo supplierDemo = new SupplierDemo();
        System.out.println(supplierDemo.get());*/

        //alternative way:
        /*Supplier<String> supplier = new SupplierDemo();
        System.out.println(supplier.get());*/

        Supplier<String> supplier = ()->"Arif Ahmed";
        System.out.println(supplier.get());

        //List<String> list = Arrays.asList("arif", "ahmed");
        List<String> list = Arrays.asList();

        System.out.println(list.stream().findAny().orElseGet(()->"AA"));;


    }
}
