package com.coding.learning.java8.streams;

import java.util.List;
import java.util.Optional;

public class ReduceDemo {

  public static void main(String[] args) {
    final List<Integer> numbers = List.of(1, 2, 3, 4, 5);
    final Integer sum = numbers.stream().mapToInt(Integer::intValue).reduce(0, (a, b) -> a + b);
    System.out.println(sum);
    Integer total = numbers.stream().mapToInt(Integer::intValue).sum();
    System.out.println(total);

    final Optional<Integer> totalSum = numbers.stream().reduce(Integer::sum);
    System.out.println(totalSum);

    final Integer maxValue = numbers.stream().reduce(0, (a, b) -> a > b ? a : b);
    System.out.println(maxValue);
    final Optional<Integer> maxValueOptional = numbers.stream().reduce(Integer::max);
    System.out.println(maxValueOptional);
  }
}
