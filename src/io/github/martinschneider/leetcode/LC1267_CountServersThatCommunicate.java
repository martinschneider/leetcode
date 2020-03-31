package io.github.martinschneider.leetcode;

// https://leetcode.com/problems/count-servers-that-communicate/
public class LC1267_CountServersThatCommunicate {
  public int countServers(int[][] grid) {
    int[] rows = new int[grid.length];
    int[] columns = new int[grid[0].length];
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] == 1) {
          rows[i]++;
          columns[j]++;
        }
      }
    }
    int count = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] == 1) {
          if (rows[i] > 1 || columns[j] > 1) {
            count++;
          }
        }
      }
    }
    return count;
  }
}
