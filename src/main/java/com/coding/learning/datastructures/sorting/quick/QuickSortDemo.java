package com.coding.learning.datastructures.sorting.quick;

import static org.apache.commons.lang3.ArrayUtils.swap;

import java.util.Arrays;

public class QuickSortDemo {

  public static void main(String[] args) {
    int array[] = {3, 1, 2, 5, 4};
//    int returnedIndex = pivot(array, 0, array.length - 1);
//    System.out.println("Returned Index: " + returnedIndex);
    quickSort(array, 0, array.length - 1);
    System.out.println(Arrays.toString(array));
  }

  private static void quickSort(int[] array, int left, int right) {
    if (left < right) {
      final int pivot = pivot(array, left, right);
      quickSort(array, left, pivot - 1);
      quickSort(array, pivot + 1, right);
    }
  }

  private static int pivot(int[] array, int pivotIndex, int endIndex) {
    int swapIndex = pivotIndex;
    for (int i = pivotIndex + 1; i <= endIndex; i++) {
      if (array[i] < array[pivotIndex]) {
        swapIndex++;
        swap(array, swapIndex, i);
      }
    }
    swap(array, pivotIndex, swapIndex);
    return swapIndex;
  }

  private static void swap(int[] array, int firstIndex, int secondIndex) {
    int temp = array[firstIndex];
    array[firstIndex] = array[secondIndex];
    array[secondIndex] = temp;
  }
}
