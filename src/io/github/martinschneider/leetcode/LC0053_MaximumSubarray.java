package io.github.martinschneider.leetcode;

// https://leetcode.com/problems/maximum-subarray/
public class LC0053_MaximumSubarray {
  public int maxSubArray(int[] nums) {
    int max = nums[0];
    for (int i = 1; i < nums.length; i++) {
      if (nums[i - 1] > 0) {
        nums[i] += nums[i - 1];
      }
      max = Math.max(nums[i], max);
    }
    return max;
  }
}
