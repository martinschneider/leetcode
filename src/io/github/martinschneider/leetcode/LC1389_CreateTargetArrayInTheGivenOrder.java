package io.github.martinschneider.leetcode;

import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/create-target-array-in-the-given-order/
public class LC1389_CreateTargetArrayInTheGivenOrder {
  public int[] createTargetArray(int[] nums, int[] index) {
    List<Integer> targetList = new LinkedList<>();
    for (int i = 0; i < nums.length; i++) {
      targetList.add(index[i], nums[i]);
    }
    return targetList.stream().mapToInt(i -> i).toArray();
  }
}
