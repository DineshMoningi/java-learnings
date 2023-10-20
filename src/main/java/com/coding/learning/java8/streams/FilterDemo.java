package com.coding.learning.java8.streams;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FilterDemo {

  public static void main(String[] args) {
    final List<Integer> integers = List.of(10, 20, 2, 3, 5, 65, 320, 11);
    Map<Integer, Integer> numbers = new HashMap<>();

    numbers.put(1, 10);
    numbers.put(2, 14);
    numbers.put(3, 9);
    numbers.put(4, 7);

    final Map<Integer, Integer> collect = numbers.entrySet().stream()
        .filter(p -> p.getValue() % 2 != 0)
//            .forEach( p-> System.out.println(p));
        .collect(Collectors.toMap(p -> p.getKey(), q -> q.getValue()));
    System.out.println(collect);
  }
}
