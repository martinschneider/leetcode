package io.github.martinschneider.leetcode;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/two-sum/
public class LC0001_TwoSum {
  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> indices = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      indices.put(nums[i], i);
    }
    for (int idx1 = 0; idx1 < nums.length; idx1++) {
      Integer idx2 = indices.get(target - nums[idx1]);
      if (idx2 != null && idx2 != idx1)
        return new int[] {idx1, idx2};
    }
    return null;
  }
}
