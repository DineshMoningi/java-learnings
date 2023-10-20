package com.coding.learning.java8.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Employee {

  private String name;
  private int age;
  private double salary;

  public Employee(String name, int age, double salary) {
    this.name = name;
    this.age = age;
    this.salary = salary;
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

  public double getSalary() {
    return salary;
  }

  public void setSalary(double salary) {
    this.salary = salary;
  }

  @Override
  public String toString() {
    return "Employee{" +
        "name='" + name + '\'' +
        ", age=" + age +
        ", salary=" + salary +
        '}';
  }
}

public class ListSortingDemo {

  public static List<Employee> getEmployees() {
    return List.of(
        new Employee("Dinesh", 35, 10000),
        new Employee("Ritu", 35, 7000),
        new Employee("Hari", 35, 8000),
        new Employee("Kumar", 30, 50000)
    ).stream().collect(Collectors.toList());
  }

  public static void main(String[] args) {
    final Map<String, Employee> employeeMap = getEmployees().stream()
        .collect(Collectors.toMap(p -> p.getName(), q -> q));
    final List<Entry<String, Employee>> entries = new ArrayList<>(employeeMap.entrySet());
    Collections.sort(entries, new Comparator<Entry<String, Employee>>() {
      @Override
      public int compare(Entry<String, Employee> o1, Entry<String, Employee> o2) {
        return o2.getKey().compareTo(o1.getKey());
      }
    });
    System.out.println(entries);
    Collections.sort(entries, Comparator.comparing(Entry::getKey));
    System.out.println(entries);

    Collections.sort(entries, (e1, e2) -> e2.getKey().compareTo(e1.getKey()));
    System.out.println(entries);

    final Map<Integer, Employee> treemap = new TreeMap<>((o1, o2) -> o1 - o2);
    final Map<Employee, Integer> treemap2 = new TreeMap<>(Comparator.comparing(Employee::getName));

    treemap.put(1, new Employee("Dinesh", 35, 10000));
    treemap.put(4, new Employee("Dinesh", 35, 10000));
    treemap.put(3, new Employee("Dinesh", 35, 10000));
    treemap.put(2, new Employee("Dinesh", 35, 10000));
    System.out.println(treemap);
    System.out.println("------------------");
    employeeMap.entrySet().stream()
        .sorted(Comparator.comparing(Entry::getKey)).forEach(System.out::println);

    System.out.println("------------------");
    employeeMap.entrySet().stream()
        .sorted(Map.Entry.comparingByValue(Comparator.comparing(Employee::getSalary).reversed())).forEach(System.out::println);
  }
}
