package io.github.martinschneider.leetcode;

// https://leetcode.com/problems/angle-between-hands-of-a-clock/
public class LC1344_AngleBetweenHandsOfAClock {
  public double angleClock(int hour, int minutes) {
    double hourPosition = (hour % 12) * 30 + (double) minutes / 2;
    double minPosition = minutes * 6;
    double angle = hourPosition - minPosition;
    if (angle < 0)
      angle = 360 + angle;
    if (angle > 180)
      angle = 360 - angle;
    return angle;
  }
}
