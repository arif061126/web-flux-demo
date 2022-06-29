package com.webfluxdemo.streamExample;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeService {

    public static List<Employee> evaluateTaxUsers(String input){
        //EmployeeDAO employeeDAO = new EmployeeDAO();
        return (input.equalsIgnoreCase("Tax")) ?
            EmployeeDAO
                    .getEmployees()
                    .stream()
                    .filter(e -> e.getSalary() > 2000L)
                    .collect(Collectors.toList()) :
            EmployeeDAO
                    .getEmployees()
                    .stream()
                    .filter(e -> e.getSalary() <= 2000L)
                    .collect(Collectors.toList());

    }

    public static void main(String[] args) {

        System.out.println(evaluateTaxUsers("Other"));
        System.out.println(evaluateTaxUsers("Tax"));

    }
}
