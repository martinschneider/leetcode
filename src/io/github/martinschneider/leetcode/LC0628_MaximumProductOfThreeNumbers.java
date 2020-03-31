package io.github.martinschneider.leetcode;

import java.util.Arrays;

// https://leetcode.com/problems/maximum-product-of-three-numbers/
public class LC0628_MaximumProductOfThreeNumbers {
  public int maximumProduct(int[] nums) {
    Arrays.sort(nums);
    return Math.max(nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3],
        nums[0] * nums[1] * nums[nums.length - 1]);
  }
}
