package io.github.martinschneider.leetcode;

// https://leetcode.com/problems/element-appearing-more-than-25-in-sorted-array/
public class LC1287_ElementAppearingMoreThan25PercentInSortedArray {
  public int findSpecialInteger(int[] arr) {
    int count = 0;
    int curr = arr[0];
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == curr) {
        count++;
      } else {
        curr = arr[i];
        count = 0;
      }
      if (count > arr.length / 4) {
        return curr;
      }
    }
    return curr;
  }
}
