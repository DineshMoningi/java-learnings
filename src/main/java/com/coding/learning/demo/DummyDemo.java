package com.coding.learning.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DummyDemo {

  private final static DummyDemo INSTANCE = new DummyDemo();

  private DummyDemo() {

  }

  public static synchronized DummyDemo getInstance() {
    synchronized (DummyDemo.class) {
      return INSTANCE;
    }
  }

  static class Employee {

    public String name;
    public Double salary;
    public String dept;

    public Employee(String name, Double salary, String dept) {
      this.name = name;
      this.salary = salary;
      this.dept = dept;
    }


    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      Employee employee = (Employee) o;
      return Objects.equals(name, employee.name) && Objects.equals(salary,
          employee.salary) && Objects.equals(dept, employee.dept);
    }

    @Override
    public int hashCode() {
      return Objects.hash(name, salary, dept);
    }

//    @Override
//    public String toString() {
//      return "Employee{" +
//          "name='" + name + '\'' +
//          ", salary=" + salary +
//          ", dept='" + dept + '\'' +
//          '}';
//    }
  }

  public static void main(String[] args) {
    final Employee dinesh = new Employee("Dinesh", 12345.0, "IT");
    final Employee dineshCopy = new Employee("Dinesh", 12345.0, "IT");

    final List<Employee> employees = List.of(dinesh, dineshCopy);
    System.out.println(dinesh.equals(dineshCopy));
    System.out.println(dinesh == dineshCopy);
    System.out.println(dinesh);
    System.out.println(dineshCopy);
    Employee t1 = null;
    Employee t2 = null;
    final Map<String, List<Employee>> empDept = employees.stream()
        .collect(Collectors.groupingBy(e -> e.dept));
//    empDept.put()
//    System.out.println(t1 == t2);
//    System.out.println("".equals(" "));

    final String dineshkumarmoningi = "dineshkumarmoningi";


  }
}
