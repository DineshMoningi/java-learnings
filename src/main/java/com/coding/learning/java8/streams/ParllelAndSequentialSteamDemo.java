package com.coding.learning.java8.streams;

import java.io.InputStream;
import java.util.stream.IntStream;

public class ParllelAndSequentialSteamDemo {

  public static void main(String[] args) {
    long startTime = System.currentTimeMillis();
    IntStream.range(1, 100).forEach(System.out::print);
    System.out.println("Time took - " + (System.currentTimeMillis() - startTime));
    startTime = System.currentTimeMillis();
    IntStream.range(1, 100).parallel().forEach(System.out::print);
    System.out.println("Time took - " + (System.currentTimeMillis() - startTime));
  }
}
