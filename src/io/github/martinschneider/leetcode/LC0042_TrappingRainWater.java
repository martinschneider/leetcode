package io.github.martinschneider.leetcode;

// https://leetcode.com/problems/trapping-rain-water/
public class LC0042_TrappingRainWater {
  public int trap(int[] height) {
    if (height.length == 0)
      return 0;
    int maxLeft[] = new int[height.length];
    int maxRight[] = new int[height.length];
    maxLeft[0] = height[0];
    for (int i = 1; i < height.length; i++) {
      maxLeft[i] = Math.max(maxLeft[i - 1], height[i]);
    }
    maxRight[height.length - 1] = height[height.length - 1];
    for (int i = height.length - 2; i >= 0; i--) {
      maxRight[i] = Math.max(maxRight[i + 1], height[i]);
    }
    int water = 0;
    for (int i = 0; i < height.length; i++) {
      water += Math.min(maxLeft[i], maxRight[i]) - height[i];
    }
    return water;
  }
}
