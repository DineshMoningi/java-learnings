package com.coding.learning.datastructures.sorting.selection;

import java.util.Arrays;

public class SelectionSortDemo {

  public static void main(String[] args) {
    int[] array = new int[]{6, 4, 5, 3, 1, 2};
    sort(array);
    System.out.println(Arrays.toString(array));
  }

  static void sort(int[] array) {
    for (int i = 0; i < array.length; i++) {
      int minIndex = i;
      for (int j = i + 1; j < array.length; j++) {
        if (array[minIndex] > array[j]) {
          minIndex = j;
        }
      }
      if (i != minIndex) {
        int temp = array[minIndex];
        array[minIndex] = array[i];
        array[i] = temp;
      }
    }
  }
}
