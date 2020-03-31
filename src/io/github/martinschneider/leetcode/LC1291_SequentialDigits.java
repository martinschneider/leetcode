package io.github.martinschneider.leetcode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/sequential-digits/
public class LC1291_SequentialDigits {
  public List<Integer> sequentialDigits(int low, int high) {
    int lowerDigits = getNumberOfDigits(low);
    int higherDigits = getNumberOfDigits(high);
    List<Integer> numbers = new ArrayList<Integer>();
    for (int i = lowerDigits; i <= higherDigits; i++) {
      for (int j = 1; j <= 10 - i; j++) {
        int number = 0;
        int digit = j;
        for (int k = i - 1; k >= 0; k--) {
          number += digit * Math.pow(10, k);
          digit++;
        }
        if (number > high)
          break;
        else if (number >= low)
          numbers.add(number);
      }
    }
    return numbers;
  }

  private int getNumberOfDigits(int number) {
    int digits = 0;
    while (number > 0) {
      number /= 10;
      digits++;
    }
    return digits;
  }
}
