package com.coding.learning.datastructures.sorting.babble;

import java.util.Arrays;

public class BubbleSortDemo {

  public static void main(String[] args) {
    int[] array = new int[] {1, 4, 5,6, 2, 3};
    sort(array);
    Arrays.stream(array).forEach(System.out::println);
  }

  static void sort(int[] array) {
    if (array == null) {
      return;
    }
    for (int i = array.length - 1; i > 0; i--) {
      for (int j = 0; j < i; j++) {
//    for(int i = 0; i < array.length -1; i++) {
//      for(int j =0; j < array.length -1; j++) {
        if (array[j] > array[j + 1]) {
          int temp = array[j];
          array[j] = array[j+1];
          array[j+1] = temp;
        }
      }
    }
  }
}
