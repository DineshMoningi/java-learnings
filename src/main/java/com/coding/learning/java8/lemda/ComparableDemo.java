package com.coding.learning.java8.lemda;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class Employee implements Comparable<Employee> {
  private String name;
  private int age;
  private String designation;

  public Employee(String name, int age, String designation) {
    this.name = name;
    this.age = age;
    this.designation = designation;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getDesignation() {
    return designation;
  }

  public void setDesignation(String designation) {
    this.designation = designation;
  }

  @Override
  public int compareTo(Employee o) {
    return o.name.compareTo(this.name);
  }

  @Override
  public String toString() {
    return "Employee{" +
        "name='" + name + '\'' +
        ", age=" + age +
        ", designation='" + designation + '\'' +
        '}';
  }
}

public class ComparableDemo {
  public static List<Employee> getEmployees() {
    return List.of(
        new Employee("Dinesh", 33, "SSE"),
        new Employee("Kumar", 30, "SE"),
        new Employee("Ritu", 33, "M"),
        new Employee("Hari", 40, "SM")
    ).stream().collect(Collectors.toList());
  }

  public static void main(String[] args) {
    final List<Employee> employees = getEmployees();
    Collections.sort(employees);
    System.out.println(employees);
  }
}
