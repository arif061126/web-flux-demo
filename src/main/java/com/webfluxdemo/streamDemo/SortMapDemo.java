package com.webfluxdemo.streamDemo;

import com.webfluxdemo.streamExample.Employee;

import java.util.*;

public class SortMapDemo {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1,"shohag");
        map.put(2,"asif");
        map.put(3,"arif");
        map.put(4,"tanvir");

        System.out.println(map);

        //map.entrySet().stream().forEach(System.out::println);
        map.entrySet().stream().forEach(m-> System.out.println(m));

        //Traditional approach:

        //step:1 : we need to convert the map into list:
        List<Map.Entry<Integer, String>> entries = new ArrayList<>(map.entrySet());

        //step:2 : now sort the list
        Collections.sort(entries, new Comparator<Map.Entry<Integer, String>>() {
            @Override
            public int compare(Map.Entry<Integer, String> o1, Map.Entry<Integer, String> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        System.out.println("Traditional approach:::::::");

        for(Map.Entry<Integer, String> entry : entries){
            System.out.println(entry.getKey()+": "+entry.getValue());
        }


        ///new approach::::::
        System.out.println("New approach:::::::");
        //step:1 : we need to convert the map into list:
        List<Map.Entry<Integer, String>> entries2 = new ArrayList<>(map.entrySet());

        System.out.println("Before sort"+entries2);

        //step:2 : now sort the list
        Collections.sort(entries2, (o1, o2)-> o1.getValue().compareTo(o2.getValue()));
        System.out.println("after sort::::::: ");
        entries2.stream().forEach(entry->System.out.println(entry.getKey()+": "+entry.getValue()));
        /*for(Map.Entry<Integer, String> entry : entries2){
            System.out.println(entry.getKey()+": "+entry.getValue());
        }*/

        //approach 2::::::::
        System.out.println("approach 2::::::::");

        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(entry->System.out.println(entry.getKey()+": "+entry.getValue()));

        System.out.println("reverse sort::::::::");

        //approach 1::::::::

        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(entry->System.out.println(entry.getKey()+": "+entry.getValue()));

        //approach 2::::::::

        /*map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.comparing(o ->o.toString()).reversed()))
                .forEach(entry->System.out.println(entry.getKey()+": "+entry.getValue()));*/

        //approach 3::::::::

        /*map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.comparing(String::toString).reversed()))
                .forEach(entry->System.out.println(entry.getKey()+": "+entry.getValue()));*/


        System.out.println("++++++++++++++Map Example++++++++++++++");
        //Map<Employee, Integer> employeeMap = new HashMap<>();
        /*Map<Employee, Integer> employeeMap = new TreeMap<>(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getSalary().compareTo(o2.getSalary());
            }
        });*/

        /*Map<Employee, Integer> employeeMap = new TreeMap<>((o1, o2)->
                o1.getSalary().compareTo(o2.getSalary())
        );*/

        Map<Employee, Integer> employeeMap = new TreeMap<>(Comparator.comparing(Employee::getSalary));

        employeeMap.put(new Employee(101,"Arif","IT", 4000L),30);
        employeeMap.put(new Employee(102,"Asif","Civil", 2000L),60);
        employeeMap.put(new Employee(103,"Akif","Data", 1000L),10);
        employeeMap.put(new Employee(103,"Alif","Management", 3000L),20);

        System.out.println(employeeMap);
        employeeMap.entrySet().stream().forEach(m-> System.out.println(m));

        //step:1 : we need to convert the map into list:
        List<Map.Entry<Employee, Integer>> entries1 = new ArrayList<>(employeeMap.entrySet());

        //step:2 : now sort the list
        Collections.sort(entries1, new Comparator<Map.Entry<Employee, Integer>>() {
            @Override
            public int compare(Map.Entry<Employee,Integer> o1, Map.Entry<Employee,Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        System.out.println("Traditional approach:::::::");

        for(Map.Entry<Employee,Integer> entry : entries1){
            System.out.println(entry.getKey()+": "+entry.getValue());
        }

        //++++++++++++new approach++++++++++++

        Map<Employee, Integer> employeeMap1 = new HashMap<>();

        employeeMap1.put(new Employee(101,"Arif","IT", 4000L),30);
        employeeMap1.put(new Employee(102,"Asif","Civil", 2000L),60);
        employeeMap1.put(new Employee(103,"Akif","Data", 1000L),10);
        employeeMap1.put(new Employee(103,"Alif","Management", 3000L),20);

        System.out.println("Before sort:::::::");
        System.out.println(employeeMap1);

        System.out.println("New approach:::::::");

        employeeMap1
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getSalary)))
                .forEach(System.out::println);

        System.out.println(":::::::::For descending order:::::::");

        employeeMap1
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getSalary).reversed()))
                .forEach(System.out::println);

        System.out.println(":::::::::For ascending order by value:::::::");

        employeeMap1
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.comparing(e->e.toString())))
                .forEach(System.out::println);

        //::::::::::::Approach 2::::::::::
        /*employeeMap1
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.comparing(Object::toString)))
                .forEach(System.out::println);*/


        System.out.println(":::::::::For descending order by value:::::::");

        employeeMap1
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.comparing(e->e.toString()).reversed()))
                .forEach(System.out::println);

        //::::::::::::Approach 2::::::::::
        /*employeeMap1
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.comparing(Object::toString).reversed()))
                .forEach(System.out::println);*/
    }
}
