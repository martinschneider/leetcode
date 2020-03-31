package io.github.martinschneider.leetcode;

import java.util.Deque;
import java.util.LinkedList;

// https://leetcode.com/problems/string-to-integer-atoi/
public class LC0008_StringToIntegerAtoi {
  public int myAtoi(String str) {
    str = str.trim();
    if (str.length() == 0)
      return 0;
    Deque<Integer> digits = new LinkedList<>();
    char[] chars = str.toCharArray();
    int startIdx = 0;
    int factor = 1;
    switch (chars[0]) {
      case '+':
        startIdx = 1;
        break;
      case '-':
        startIdx = 1;
        factor = -1;
        break;
      default:
        if (!Character.isDigit(chars[0]))
          return 0;
    }
    for (int i = startIdx; i < chars.length; i++) {
      if (Character.isDigit(chars[i])) {
        int digit = Character.getNumericValue(chars[i]);
        if (digit != 0 || !digits.isEmpty())
          digits.push(digit);
      } else {
        break;
      }
    }
    return (int) (factor * stackToNumber(digits, factor, 10));
  }

  private long stackToNumber(Deque<Integer> digits, int factor, int radix) {
    long result = 0;
    long power = 1;
    int exp = 1;
    while (!digits.isEmpty()) {
      result += power * digits.pop();
      if (exp > 18 || result * factor > Integer.MAX_VALUE)
        return Integer.MAX_VALUE;
      if (exp > 18 || result * factor < Integer.MIN_VALUE)
        return Integer.MIN_VALUE;
      power *= radix;
      exp++;
    }
    return result;
  }
}
