package com.coding.learning.java8.functional;

import java.util.function.Predicate;

public class PredicateDemo {

  public static void main(String[] args) {
    final Employee dinesh = new Employee("Dinesh", 25);
    Predicate<Employee> predicate = (employee -> employee.getAge() > 20);
    System.out.println(dinesh.getName() + " Is eligible for voting? " + predicate.test(dinesh));

    // Predicate will be used in filter method
  }
}
