package com.coding.learning.java8.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javax.sound.midi.Soundbank;

class Employee {
  String name;
  String email;
  String phone;
  Double salary;
  String dept;

  public Employee(String name, String email, String phone, Double salary, String dept) {
    this.name = name;
    this.email = email;
    this.phone = phone;
    this.salary = salary;
    this.dept = dept;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public String getPhone() {
    return phone;
  }

  public Double getSalary() {
    return salary;
  }

  public String getDept() {
    return dept;
  }
}
public class SteamApiDemo {

  public static void main(String[] args) {
    final List<Employee> employees = List.of(
        new Employee("Dinesh", "a@a.com", "1234567890", 10000.0, "A"),
        new Employee("Kumar", "b@a.com", "1234567891", 10001.0, "B"),
        new Employee("Moningi", "c@a.com", "1234567892", 10002.0, "C"),
        new Employee("Moningi", "c@a.com", "1234567892", 10002.0, "A")
    );

//    final List<String> names = employees.stream().map(Employee::getName).collect(Collectors.toList());
//    System.out.println(names);
//
    String str = "Dinesh Kumar Moningi";

    Function<String, Map<String, Integer>> fun = (string) -> {
      Map<String, Integer> count = new HashMap<>();
      final char[] chars = string.toCharArray();

      for(char ch: chars) {
        if(count.get(ch + "") == null) {
          count.put(ch + "", 1);
        } else {
          count.put(ch + "", count.get(ch + "") + 1);
        }
      }
      return count;
    };

    System.out.println(fun.apply("Dinesh Kumar Moningi"));

    final Map<String, Long> charactersCount = Arrays.stream(str.split(""))
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    System.out.println(charactersCount);
    final Comparator<Employee> comparing = Comparator.comparing(Employee::getSalary);

    final Map<String, Double> collect = employees.stream()
        .collect(Collectors.groupingBy(Employee::getDept, Collectors.reducing(
            BinaryOperator.maxBy(comparing)))).entrySet().stream()
        .collect(Collectors.toMap(p -> p.getValue().get().getDept(),
            q -> q.getValue().get().getSalary()));

    System.out.println(collect);

    IntStream.rangeClosed(1, 10).forEach(System.out::println);
  }
}
