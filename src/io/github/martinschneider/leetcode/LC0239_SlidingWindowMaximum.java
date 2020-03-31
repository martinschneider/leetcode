package io.github.martinschneider.leetcode;

// https://leetcode.com/problems/sliding-window-maximum/
public class LC0239_SlidingWindowMaximum {
  public int[] maxSlidingWindow(int[] nums, int k) {
    if (nums.length == 0)
      return new int[] {};
    int[] sums = new int[nums.length - k + 1];
    for (int i = 0; i < sums.length; i++) {
      int max = nums[i];
      for (int j = i + 1; j < i + k; j++) {
        max = Math.max(max, nums[j]);
      }
      sums[i] = max;
    }
    return sums;
  }
}
