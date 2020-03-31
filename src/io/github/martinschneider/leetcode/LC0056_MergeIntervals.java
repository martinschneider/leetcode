package io.github.martinschneider.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// https://leetcode.com/problems/merge-intervals/
public class LC0056_MergeIntervals {
  public int[][] merge(int[][] intervals) {
    Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
    List<int[]> result = new ArrayList<>();
    int left = Integer.MIN_VALUE;
    int right = Integer.MIN_VALUE;
    for (int i = 0; i < intervals.length; i++) {
      if (intervals[i][0] <= right) {
        left = Math.min(left, intervals[i][0]);
        right = Math.max(right, intervals[i][1]);
      } else {
        if (left > Integer.MIN_VALUE)
          result.add(new int[] {left, right});
        left = intervals[i][0];
        right = intervals[i][1];
      }
    }
    if (left > Integer.MIN_VALUE)
      result.add(new int[] {left, right});
    int[][] array = new int[result.size()][2];
    for (int i = 0; i < result.size(); i++) {
      array[i][0] = result.get(i)[0];
      array[i][1] = result.get(i)[1];
    }
    return array;
  }
}
