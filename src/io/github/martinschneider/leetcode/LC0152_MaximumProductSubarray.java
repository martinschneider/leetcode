package io.github.martinschneider.leetcode;

// https://leetcode.com/problems/maximum-product-subarray/
public class LC0152_MaximumProductSubarray {
  public int maxProduct(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    int globalMax = Integer.MIN_VALUE;
    int max = 1;
    int min = 1;
    for (int num : nums) {
      int tmp = max;
      max = Math.max(Math.max(max * num, min * num), num);
      min = Math.min(Math.min(min * num, tmp * num), num);
      if (max > globalMax) {
        globalMax = max;
      }
    }
    return globalMax;
  }
}
