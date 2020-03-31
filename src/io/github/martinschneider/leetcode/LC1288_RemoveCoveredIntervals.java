package io.github.martinschneider.leetcode;

import java.util.Arrays;

// https://leetcode.com/problems/remove-covered-intervals/
public class LC1288_RemoveCoveredIntervals {
  public int removeCoveredIntervals(int[][] intervals) {
    int size = intervals.length;
    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0] - a[1], b[0] - b[1]));
    for (int i = 1; i < intervals.length; i++) {
      for (int j = 0; j < i; j++) {
        if (intervals[j][0] <= intervals[i][0] && intervals[j][1] >= intervals[i][1]) {
          size--;
          break;
        }
      }
    }
    return size;
  }
}
