package io.github.martinschneider.leetcode;

// https://leetcode.com/problems/zigzag-conversion/
public class LC0006_ZigZagConversion {
  private static final int DOWN = 1;
  private static final int UP = 2;

  public String convert(String s, int numRows) {
    if (numRows == 1)
      return s;
    int numCols = Math.max(1, (numRows - 1) * (s.length() / (2 * (numRows - 1))) + (numRows - 1));
    System.out.println(numCols);
    char[][] array = new char[numRows][numCols];
    int row = 0;
    int col = 0;
    int direction = DOWN;
    for (char chr : s.toCharArray()) {
      array[row][col] = chr;
      if (direction == DOWN) {
        if (row < numRows - 1)
          row++;
        else {
          direction = UP;
          row--;
          col++;
        }
      } else {
        if (row > 0) {
          row--;
          col++;
        } else {
          direction = DOWN;
          row++;
        }
      }
    }
    StringBuilder result = new StringBuilder();
    for (int j = 0; j < numRows; j++) {
      for (int i = 0; i < numCols; i++) {
        if (array[j][i] != Character.MIN_VALUE) {
          result.append(array[j][i]);
        }
      }
    }
    return result.toString();
  }
}
