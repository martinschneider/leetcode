package io.github.martinschneider.leetcode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/minimum-number-of-taps-to-open-to-water-a-garden/
public class LC1326_MinimumNumberOfTapsToOpenToWaterAGarden {
  public int minTaps(int n, int[] ranges) {
    int pointToCover = 0;
    int nrOfTaps = 0;
    List<Integer> taps = new ArrayList<Integer>();
    while (pointToCover < n) {
      int max = -1;
      int maxIdx = -1;
      for (int i = 0; i < ranges.length; i++) {
        if (i - ranges[i] <= pointToCover) {
          if (i + ranges[i] > max) {
            max = i + ranges[i];
            maxIdx = i;
          }
        }
      }
      if (maxIdx == -1 || max == pointToCover) {
        return -1;
      }
      nrOfTaps++;
      taps.add(maxIdx);
      pointToCover = max;
    }
    return nrOfTaps;
  }
}
