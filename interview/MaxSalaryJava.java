package com.codesmentors.interview;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() { return name; }
    public double getSalary() { return salary; }

    @Override
    public String toString() {
        return name + " (" + salary + ")";
    }
}

public class MaxSalaryJava {

	public static void main(String[] args) {
		
		//Same employee data
		List<Employee> employees = Arrays.asList(
				new Employee("Amit",50000),
				new Employee("Sneha",70000),
				new Employee("Ravi",70000),
				new Employee("Priya",60000));
				
		//Step 1: Find max salary
		double maxSalary=employees.stream().mapToDouble(Employee::getSalary)
										.max().orElseThrow(() -> new RuntimeException("No employees"));
		
		//Step 2: Select employees with that max salary
		List<String> topEmployees=employees.stream()
				.filter(e -> e.getSalary() == maxSalary)
				.map(Employee::getName)
				.collect(Collectors.toList());
		//Step 3: Output
		System.out.println("Employees with max salary ("+maxSalary+ "): "+topEmployees);
		}
}
