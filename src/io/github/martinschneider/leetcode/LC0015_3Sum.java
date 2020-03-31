package io.github.martinschneider.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/3sum/
public class LC0015_3Sum {
  public List<List<Integer>> threeSum(int[] nums) {
    Set<List<Integer>> results = new HashSet<List<Integer>>();
    Map<Integer, Integer> searchMap = new HashMap<Integer, Integer>();
    for (int i = 0; i < nums.length; i++) {
      Integer number = searchMap.get(nums[i]);
      searchMap.put(nums[i], (number != null) ? number + 1 : 1);
    }
    for (int i = 0; i < nums.length; i++) {
      int currValue = searchMap.get(Integer.valueOf(nums[i]));
      searchMap.put(Integer.valueOf(nums[i]), currValue - 1);
      for (int j = i + 1; j < nums.length; j++) {
        currValue = searchMap.get(Integer.valueOf(nums[j]));
        searchMap.put(Integer.valueOf(nums[j]), currValue - 1);
        Integer count = searchMap.get(Integer.valueOf(-nums[i] - nums[j]));
        if (count != null && count > 0) {
          List<Integer> result = Arrays.asList(nums[i], nums[j], -nums[i] - nums[j]);
          Collections.sort(result);
          results.add(result);
        }
        currValue = searchMap.get(Integer.valueOf(nums[j]));
        searchMap.put(Integer.valueOf(nums[j]), currValue + 1);
      }
      currValue = searchMap.get(Integer.valueOf(nums[i]));
      searchMap.put(Integer.valueOf(nums[i]), currValue + 1);
    }
    return new ArrayList<List<Integer>>(results);
  }
}
