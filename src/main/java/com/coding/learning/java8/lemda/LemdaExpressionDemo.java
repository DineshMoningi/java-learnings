package com.coding.learning.java8.lemda;

import java.util.function.Predicate;

@FunctionalInterface
interface MyFunction<T, U> {
  T test(U u);
}

//interface Predicate<U> {
//  boolean test(U u);
//}

interface Function<T, U, V> {

}
public class LemdaExpressionDemo {
  static int  s = 1;

  public void test() {
    int s = 20;
  }
  public static void main(String[] args) {
    int s = 30;
    MyFunction<String, String> fun = (i2) -> i2 + 10;

    System.out.println(fun.test("20"));

    Predicate<Integer> pre = (i) -> i > 10;
  }
}
