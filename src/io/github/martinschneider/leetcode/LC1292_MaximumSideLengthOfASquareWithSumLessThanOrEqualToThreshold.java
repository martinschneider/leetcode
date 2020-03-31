package io.github.martinschneider.leetcode;

// https://leetcode.com/problems/maximum-side-length-of-a-square-with-sum-less-than-or-equal-to-threshold/
public class LC1292_MaximumSideLengthOfASquareWithSumLessThanOrEqualToThreshold {

  int threshold;

  public int maxSideLength(int[][] mat, int threshold) {
    this.threshold = threshold;
    if (mat.length == 0) {
      return 0;
    }
    int result = 0;
    for (int i = 0; i <= Math.min(mat.length, mat[0].length); i++) {
      // check for squares of size i
      if (result <= i - 1)
        break;
      for (int j = 0; j < mat.length - i; j++) {
        for (int k = 0; k < mat[j].length - i; k++) {
          if (calculateSquare(mat, i + 1, j, k) <= threshold) {
            result = i + 1;
            break;
          }
        }
        if (result == i + 1)
          break;
      }
    }
    return result;
  }

  private int calculateSquare(int[][] mat, int size, int x, int y) {
    int sum = 0;
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        sum += mat[x + i][y + j];
      }
    }
    return sum;
  }
}
