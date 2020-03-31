package io.github.martinschneider.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://leetcode.com/problems/lucky-numbers-in-a-matrix/
public class LC1380_LuckyNumbersInAMatrix {
  public List<Integer> luckyNumbers(int[][] matrix) {
    if (matrix.length == 0) {
      return Collections.emptyList();
    }
    List<Integer> results = new ArrayList<>();
    int rowMin[] = new int[matrix.length];
    for (int i = 0; i < rowMin.length; i++)
      rowMin[i] = Integer.MAX_VALUE;
    int colMax[] = new int[matrix[0].length];
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        colMax[j] = Math.max(colMax[j], matrix[i][j]);
        rowMin[i] = Math.min(rowMin[i], matrix[i][j]);
      }
    }
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        if (matrix[i][j] == colMax[j] && matrix[i][j] == rowMin[i]) {
          results.add(matrix[i][j]);
        }
      }
    }
    return results;
  }
}
