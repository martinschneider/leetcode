package io.github.martinschneider.leetcode;

// https://leetcode.com/problems/bulb-switcher-iii/
public class LC1375_BulbSwitcher3 {
  public int numTimesAllBlue(int[] light) {
    int[] bulbs = new int[light.length];
    int count = 0;
    int lowestOff = 1;
    int highestOn = -1;
    for (int i = 0; i < light.length; i++) {
      bulbs[light[i] - 1] = 1;
      highestOn = Math.max(highestOn, light[i]);
      while (lowestOff <= bulbs.length && bulbs[lowestOff - 1] == 1) {
        lowestOff++;
      }
      if (lowestOff > highestOn) {
        count++;
      }
    }
    return count;
  }
}
