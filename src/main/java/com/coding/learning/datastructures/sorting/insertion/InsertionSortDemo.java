package com.coding.learning.datastructures.sorting.insertion;

import java.util.Arrays;

public class InsertionSortDemo {

  public static void main(String[] args) {
    int[] array = new int[]{4, 5, 3, 6, 1, 2};
    sort(array);
    System.out.println(Arrays.toString(array));
  }

  static void sort(int[] array) {
    for (int i = 1; i < array.length; i++) {
      int j = i - 1;
      int temp = array[i];

      while (j > -1 && temp < array[j]) {
        array[j + 1] = array[j];
        array[j] = temp;
        j--;
      }
    }
  }
}
