package io.github.martinschneider.leetcode;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/happy-number/
public class LC0202_HappyNumber {
  public boolean isHappy(int n) {
    Set<Integer> seen = new HashSet<>();
    seen.add(n);
    while (true) {
      n = getNextNumber(n);
      if (n == 1)
        return true;
      if (seen.contains(n))
        return false;
      seen.add(n);
    }
  }

  private int getNextNumber(int n) {
    int sum = 0;
    while (n != 0) {
      sum += Math.pow(n % 10, 2);
      n /= 10;
    }
    return sum;
  }
}
