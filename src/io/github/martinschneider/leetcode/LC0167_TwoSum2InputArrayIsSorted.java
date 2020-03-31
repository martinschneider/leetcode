package io.github.martinschneider.leetcode;

// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
public class LC0167_TwoSum2InputArrayIsSorted {
  public int[] twoSum(int[] numbers, int target) {
    int i = 0;
    int j = numbers.length - 1;
    while (i < j) {
      if (numbers[i] + numbers[j] < target) {
        i++;
      } else if (numbers[i] + numbers[j] > target) {
        j--;
      } else {
        return new int[] {i + 1, j + 1};
      }
    }
    return null;
  }
}
