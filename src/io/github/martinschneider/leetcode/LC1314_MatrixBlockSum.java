package io.github.martinschneider.leetcode;

// https://leetcode.com/problems/matrix-block-sum/
public class LC1314_MatrixBlockSum {
  public int[][] matrixBlockSum(int[][] mat, int K) {
    int[][] result = new int[mat.length][mat[0].length];
    for (int i = 0; i < mat.length; i++) {
      for (int j = 0; j < mat[i].length; j++) {
        for (int k = -K; k <= K; k++) {
          for (int l = -K; l <= K; l++) {
            if (i + k >= 0 && i + k < mat.length && j + l >= 0 && j + l < mat[i].length)
              result[i][j] += mat[i + k][j + l];
          }
        }
      }
    }
    return result;
  }
}
