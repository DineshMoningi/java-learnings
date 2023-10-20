package com.coding.learning.datastructures.recursion;

public class FactorialDemo {

  public static void main(String[] args) {
    System.out.println(factorial(5));
  }

  public static int factorial(int n) {
    if(n == 1) {
      return 1;
    } else {
      return factorial(n - 1) * n;
    }
  }
}
