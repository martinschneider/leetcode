package io.github.martinschneider.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://leetcode.com/problems/permutations/
public class LC0046_Permutations {
  public List<List<Integer>> permute(int[] nums) {
    if (nums.length == 0) {
      return List.of(Collections.emptyList());
    }
    List<List<Integer>> result = new ArrayList<>();
    return perm(result, nums, 0);
  }

  private List<List<Integer>> perm(List<List<Integer>> result, int[] nums, int start) {
    for (int i = start; i < nums.length; i++) {
      int temp = nums[start];
      nums[start] = nums[i];
      nums[i] = temp;
      perm(result, nums, start + 1);
      nums[i] = nums[start];
      nums[start] = temp;
    }
    if (start == nums.length - 1) {
      List<Integer> intList = new ArrayList<>();
      for (int num : nums) {
        intList.add(num);
      }
      result.add(intList);
    }
    return result;
  }
}
