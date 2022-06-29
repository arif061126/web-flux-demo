package com.webfluxdemo.streamExample;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    public static List<Employee> getEmployees(){
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(101,"Arif","IT", 1000L));
        employeeList.add(new Employee(102,"Asif","Civil", 2000L));
        employeeList.add(new Employee(103,"Alif","Management", 3000L));
        employeeList.add(new Employee(103,"Akif","Data", 4000L));

        return employeeList;
    }

}
