package com.coding.learning.datastructures.sorting.merge;

import java.util.Arrays;

public class MergeSortDemo {
  static class A {
    public int number = 10;

    public int getNumber() {
      return number;
    }
  }
  public static void main(String[] args) {
    final int[] sorted = mergeSort(new int[]{7, 6, 2, 1, 3, 5, 4});
    System.out.println(Arrays.toString(sorted));

  }

  static int[] mergeSort(int[] array) {
    if (array.length == 1) {
      return array;
    }
    int midLength = array.length / 2;
    int left[] = mergeSort(Arrays.copyOfRange(array, 0, midLength));
    int right[] = mergeSort(Arrays.copyOfRange(array, midLength, array.length));
    return mergeSort(left, right);
  }

  static int[] mergeSort(int[] array1, int[] array2) {
    int[] combined = new int[array1.length + array2.length];
    int index = 0, i = 0, j = 0;

    while (i < array1.length && j < array2.length) {
      if (array1[i] < array2[j]) {
        combined[index] = array1[i];
        i++;
      } else {
        combined[index] = array2[j];
        j++;
      }
      index++;
    }

    while (i < array1.length) {
      combined[index] = array1[i];
      i++;
      index++;
    }

    while (j < array2.length) {
      combined[index] = array2[j];
      j++;
      index++;
    }
    return combined;
  }
}
