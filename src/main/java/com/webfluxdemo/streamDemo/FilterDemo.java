package com.webfluxdemo.streamDemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FilterDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("arif");
        list.add("bsif");
        list.add("alif");
        list.add("skif");

        //how filter works
        for(String s:list){
            if(s.startsWith("a")){
                System.out.println("without filter : "+s);
            }
        }

        list.stream().filter(t->t.startsWith("a")).forEach(s-> System.out.println("with filter : "+s));

        Map<Integer, String> map = new HashMap<>();
        map.put(1,"a");
        map.put(2,"b");
        map.put(3,"c");
        map.put(4,"d");

        map.entrySet().stream().filter(t->t.getKey()%2==0).forEach(t-> System.out.println(t));
    }
}
