package io.github.martinschneider.leetcode;

// https://leetcode.com/problems/reverse-integer/
public class LC0007_ReverseInteger {
  public int reverse(int x) {
    long reverse = 0;
    while (x != 0) {
      int digit = x % 10;
      x /= 10;
      reverse = reverse * 10 + digit;
      if (reverse > Integer.MAX_VALUE || reverse < Integer.MIN_VALUE) {
        return 0;
      }
    }
    return (int) reverse;
  }
}
