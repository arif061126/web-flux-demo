package com.webfluxdemo.mapReduce;

import com.webfluxdemo.streamExample.Employee;
import com.webfluxdemo.streamExample.EmployeeDAO;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class MapReduceExample {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2,4,5,8,9,1,3);

        List<String> words = Arrays.asList("javaCore","spring", "hibernate");

        //Traditional approach::::::
        System.out.println(":::::::Traditional approach::::::");
        int sum =0;

        for(int no:numbers){
            sum = sum+no;
        }
        System.out.println(sum);

        System.out.println(":::::::Approach--->2::::::");
        int sum1 = numbers.stream().mapToInt(i -> i).sum();//stream provided sum reduction method
        System.out.println(sum1);

        System.out.println(":::::::Approach--->3 Reduce-mapping::::::");
        Integer reduceSum = numbers.stream().reduce(0 , (a, b) -> a + b);
        //Integer reduceSum = numbers.stream().reduce((a, b) -> a + b).get();
        System.out.println(reduceSum);

        System.out.println(":::::::Approach--->4 Reduce-optional::::::");
        Optional<Integer> reduceOptional = numbers.stream().reduce(Integer::sum);
        System.out.println(reduceOptional.get());

        System.out.println("----------Multiplication--------");

        Integer malVal = numbers.stream().reduce(1, (a, b) -> a * b);
        //Integer malVal = numbers.stream().reduce((a, b) -> a * b).get();
        System.out.println(malVal);

        System.out.println("----------max with reduce()--------");

        Integer maxVal = numbers.stream().reduce(0, (a, b) -> a > b ? a : b);
        //Integer maxVal = numbers.stream().reduce((a, b) -> a > b ? a : b).get();
        System.out.println(maxVal);

        Optional<Integer> maxVal2 = numbers.stream().reduce(Integer::max);
        System.out.println(maxVal2.get());

        System.out.println("----------min with reduce()--------");

        Optional<Integer> minVal = numbers.stream().reduce(Integer::min);
        System.out.println(minVal.get());

        Integer minVal2 = numbers.stream().reduce(1, (a, b) -> a < b ? a : b);
        //Integer minVal2 = numbers.stream().reduce((a, b) -> a < b ? a : b).get();
        System.out.println(minVal2);

        String longWord = words.stream().reduce((w1, w2) -> w1.length() > w2.length() ? w1 : w2).get();
        System.out.println(longWord);

        //get all the employees
        List<Employee> employeeList = EmployeeDAO.getEmployees();
        System.out.println(employeeList);

        //get employees name start with "a"
        //get the salaries of these employee--->data trasformation
        //convert to double
        //reduction method-->average()
        //get the optional as double and return it.
        double avgSalary = employeeList
                .stream()
                .filter(e -> e.getName().toLowerCase().startsWith("a"))
                .map(s -> s.getSalary())
                .mapToDouble(i->i)
                .average()
                .getAsDouble();

        System.out.println("Average salary: "+avgSalary);

        ///sum of salary whose name starts with "a"
        Long totalSalary = employeeList
                .stream()
                .filter(a -> a.getName().toLowerCase().startsWith("a"))
                .map(s -> s.getSalary())
                .reduce(Long::sum)
                .get();

        System.out.println("Total salary: "+totalSalary);

        double totalSalary2 = employeeList
                .stream()
                .filter(a -> a.getName().toLowerCase().startsWith("a"))
                .map(s -> s.getSalary())
                .mapToDouble(i -> i)
                .sum();

        System.out.println("Total salary2: "+totalSalary2);

    }
}
