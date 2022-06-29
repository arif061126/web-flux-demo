package com.webfluxdemo.streamDemo;

import com.webfluxdemo.streamExample.Employee;
import com.webfluxdemo.streamExample.EmployeeDAO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortListDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(5);
        list.add(12);
        list.add(28);
        list.add(45);
        list.add(23);
        list.add(6);

        //traditional way of sorting:
        Collections.sort(list);
        System.out.println(list);

        //sorting in desending order:
        Collections.reverse(list);
        System.out.println(list);

        //sort using stream api:

        //List<Integer> collect = list.stream().sorted().collect(Collectors.toList()); //1st way
        //System.out.println(collect);

        System.out.println("Ascending order without list: ");
        list.stream().sorted().forEach(s-> System.out.println(s)); //2nd way
        list.stream().sorted();//2nd way
        System.out.println("Ascending order as list: "+list);
        //list.stream().sorted().forEach(System.out::println); // 3rd way

        System.out.println("--------");

        //sort in descending order:
        System.out.println("Descending order without list: ");
        list.stream().sorted(Comparator.reverseOrder()).forEach(s -> System.out.println(s));
        list.stream().sorted(Comparator.reverseOrder());
        System.out.println("Descending order as list: "+list);

        //sort in descending order in traditional way:
        /*List<Integer> toSort = new ArrayList<>();
        for (Integer s : list) {
            toSort.add(s);
        }
        toSort.sort(Comparator.reverseOrder());
        for (Integer s : toSort) {
            System.out.println(s);
        }*/


        //sort in ascending order in traditional way:
        /*List<Integer> toSort = new ArrayList<>();
        for (Integer integer : list) {
            toSort.add(integer);
        }
        toSort.sort(null);
        for (Integer integer : toSort) {
            System.out.println(integer);
        }*/

        List<Employee> employeeList = EmployeeDAO.getEmployees();

        //traditional approach of sorting
        Collections.sort(employeeList, (e1,e2)->e1.getSalary().compareTo(e2.getSalary()));//asceending order
        System.out.println(employeeList);
        Collections.sort(employeeList, (e1,e2)->e2.getSalary().compareTo(e1.getSalary()));//descending order
        System.out.println(employeeList);

        //new approach (stream api approach)
        //approach:::::1
        employeeList.stream()
                .sorted((e1,e2)->e1.getSalary().compareTo(e2.getSalary()))
                .forEach(e-> System.out.println(e));

        //approach:::::2
        /*employeeList.stream()
                .sorted(Comparator.comparing(e->e.getSalary()))
                .forEach(e-> System.out.println(e));*/

        //approach:::::3
        /*employeeList.stream()
                .sorted(Comparator.comparing(Employee::getSalary))
                .forEach(System.out::println);*/

        //approach:::::4
        /*employeeList.stream()
                .sorted((e1,e2)-> (int) (e1.getSalary()-e2.getSalary()))
                .forEach(e-> System.out.println(e));*/

        //approach:::::5
        /*employeeList.stream()
                .sorted(Comparator.comparing(Employee::getSalary))
                .forEach(e-> System.out.println(e));*/
        //System.out.println(employeeList);

        //reverse sort
        employeeList.stream()
                .sorted((e1,e2)->e2.getSalary().compareTo(e1.getSalary()))
                .forEach(e-> System.out.println(e));

        /*employeeList.stream()
                .sorted((e1,e2)-> (int) (e2.getSalary()-e1.getSalary()))
                .forEach(e-> System.out.println(e));*/
    }

    /*public static List<Employee> sortEmployee(){
        List<Employee> employeeList = EmployeeDAO.getEmployees();

        //traditional approach of sorting
        //Collections.sort(employeeList, Comparator.comparing(Employee::getSalary));
        Collections.sort(employeeList, (e1,e2)->e1.getSalary().compareTo(e2.getSalary()));

        return employeeList;
    }*/
}
