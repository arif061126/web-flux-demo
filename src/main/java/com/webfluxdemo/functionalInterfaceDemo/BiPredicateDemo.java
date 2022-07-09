package com.webfluxdemo.functionalInterfaceDemo;

import java.util.function.BiPredicate;

public class BiPredicateDemo implements BiPredicate<String, String> {
    public static void main(String[] args) {
        BiPredicate biPredicate = new BiPredicateDemo();

        System.out.println(":::::Traditional approach:::::");

        System.out.println("traditional approach: "+biPredicate.test("madam","madam"));

        System.out.println("########Annonymous Implementaion#######");

        BiPredicate<String, String> biPredicate1 = new BiPredicate<String, String>() {
            @Override
            public boolean test(String s1, String s2) {
                return s1.equals(s2);
            }
        };
        System.out.println("Annonymous implementaion: "+biPredicate1.test("demo","emo"));

        System.out.println("########Lambda Implementaion#######");

        BiPredicate biPredicate2 = (s1,s2)->s1.equals(s2);

        BiPredicate<String,String> lengthcheck = (s1,s2)->s1.length()==s2.length();

        boolean test = lengthcheck.and(biPredicate2).test("madam", "madam");
        System.out.println("check both length and palindrome: "+test);

        boolean test1 = lengthcheck.or(biPredicate2).test("ref", "er");

        System.out.println("check both length or palindrome: "+test1);

        System.out.println("Lambda implementaion: "+biPredicate2.test("aff","aff"));

    }

    //Traditional approach:::::
    @Override
    public boolean test(String s1, String s2) {
        return s1.equals(s2);
    }
}
