package com.coding.learning.java8.functional;

import java.util.List;
import java.util.function.Function;

public class FunctionDemo {

  public static void main(String[] args) {
    Function<Employee, Employee> function = (employee) -> employee;
    System.out.println(function.apply(new Employee("Testing", 30)));

    final List<Employee> integers = List.of(new Employee("Dinesh", 30));
    integers.stream().map(function);

  }
}
