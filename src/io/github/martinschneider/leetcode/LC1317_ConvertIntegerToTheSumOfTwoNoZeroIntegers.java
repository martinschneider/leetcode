package io.github.martinschneider.leetcode;

// https://leetcode.com/problems/convert-integer-to-the-sum-of-two-no-zero-integers/
public class LC1317_ConvertIntegerToTheSumOfTwoNoZeroIntegers {
  public int[] getNoZeroIntegers(int n) {
    for (int i = 1; i < n; i++) {
      if (noZeros(n - i) && noZeros(i)) {
        return new int[] {i, n - i};
      }
    }
    return null;
  }

  private boolean noZeros(int number) {
    while (number > 0) {
      if (number % 10 == 0) {
        return false;
      } else {
        number /= 10;
      }
    }
    return true;
  }
}
