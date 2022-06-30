package com.webfluxdemo.parallelStream;

import com.webfluxdemo.streamExample.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class ParallelStreamExample {

    public static List<Employee> getEmployee(){
        List<Employee> employeeList = new ArrayList<>();
        for(int i=0; i<=100; i++){
            employeeList.add(new Employee(i, "employee"+i, String.valueOf(new Random()), Long.valueOf(new Random().nextInt(1000*100))));
        }
        return employeeList;
    }

    public static void main(String[] args) {
        Long start = 0L;
        Long end = 0L;

        System.out.println("::::::::::::Sequential stream:::::::::::");

        /*start = System.currentTimeMillis();
        IntStream.range(1,10).forEach(System.out::println);
        end = System.currentTimeMillis();
        System.out.println("sequential total time: "+(end-start));*/

        IntStream.range(1,10).forEach(a-> System.out.println("Thread "+Thread.currentThread().getName()+" : "+a));

        System.out.println("::::::::::::Parallel stream:::::::::::");

        /*start = System.currentTimeMillis();
        IntStream.range(1,10).parallel().forEach(System.out::println);
        end = System.currentTimeMillis();
        System.out.println("parallel total time: "+(end-start));*/

        IntStream.range(1,10).parallel().forEach(a-> System.out.println("Thread "+Thread.currentThread().getName()+" : "+a));

        //System.out.println(getEmployee());

        System.out.println("::::::::::::Employee for Sequential stream:::::::::::");

        List<Employee> employeeList = getEmployee();

        start = System.currentTimeMillis();
        double avgSalary = employeeList.stream().map(Employee::getSalary).mapToDouble(i -> i).average().getAsDouble();
        end = System.currentTimeMillis();
        //double avgSalary = employeeList.stream().map(Employee::getSalary).mapToDouble(Long::doubleValue).average().getAsDouble();
        System.out.println("Average Salary: "+ avgSalary);
        System.out.println("parallel total time: "+(end-start));

        System.out.println("::::::::::::Employee for Parallel stream:::::::::::");

        start = System.currentTimeMillis();
        //double avgSalary2 = employeeList.stream().parallel().map(Employee::getSalary).mapToDouble(i -> i).average().getAsDouble();
        double avgSalary2 = employeeList.parallelStream().map(Employee::getSalary).mapToDouble(i -> i).average().getAsDouble();
        end = System.currentTimeMillis();
        //double avgSalary = employeeList.stream().map(Employee::getSalary).mapToDouble(Long::doubleValue).average().getAsDouble();
        System.out.println("Average Salary: "+ avgSalary2);
        System.out.println("parallel total time: "+(end-start));

    }
}
