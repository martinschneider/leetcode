package io.github.martinschneider.leetcode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/shift-2d-grid/
public class LC1260_Shift2DGrid {
  public List<List<Integer>> shiftGrid(int[][] grid, int k) {
    List<List<Integer>> ret = new ArrayList<List<Integer>>();
    for (int m = 1; m <= k; m++) {
      int last = grid[grid.length - 1][grid[0].length - 1];
      for (int i = grid.length - 1; i >= 0; i--) {
        for (int j = grid[i].length - 1; j > 0; j--) {
          grid[i][j] = grid[i][j - 1];
        }
        if (i > 0) {
          grid[i][0] = grid[i - 1][grid[0].length - 1];
        } else {
          grid[0][0] = last;
        }
      }
    }
    for (int i = 0; i < grid.length; i++) {
      List<Integer> row = new ArrayList<Integer>();
      for (int j = 0; j < grid[i].length; j++) {
        row.add(grid[i][j]);
      }
      ret.add(row);
    }
    return ret;
  }
}
