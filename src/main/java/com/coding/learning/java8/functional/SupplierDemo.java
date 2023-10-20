package com.coding.learning.java8.functional;

import java.util.List;
import java.util.function.Supplier;

public class SupplierDemo {

  public static void main(String[] args) {
    Supplier<Employee> supplier = () -> new Employee("Dinesh", 20);
    System.out.println(supplier.get());
    final List<Employee> employees = List.of(new Employee("Dinesh", 45));
    System.out.println(employees.stream().findAny().orElseGet(supplier));
  }
}
