package com.coding.learning.challanges;

public class PalindromNumberDemo {

  /*
   *     153
   *   sum = 350+1

   * */
  public static void main(String[] args) {
    int sum = 0, r, original, number = 131;
    original = number;
    while (number > 0) {
      r = number % 10;
      sum = (sum * 10) + r;
      number /= 10;
    }
    System.out.println("sum=" + sum);
    if (original == sum) {
      System.out.println("Palindrom");
    } else {
      System.out.println("Not");
    }
  }
}
