package io.github.martinschneider.leetcode;

import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/check-if-there-is-a-valid-path-in-a-grid/
public class LC1391_CheckIfThereIsAValidPathInAGrid {

  private static final List<Integer> RIGHT = Arrays.asList(1, 4, 6);
  private static final List<Integer> LEFT = Arrays.asList(1, 3, 5);
  private static final List<Integer> UP = Arrays.asList(2, 5, 6);
  private static final List<Integer> DOWN = Arrays.asList(2, 3, 4);

  public boolean hasValidPath(int[][] grid) {
    boolean visited[][] = new boolean[grid.length][grid[0].length];
    int x = 0;
    int y = 0;
    while (true) {
      if (x == grid.length - 1 && y == grid[0].length - 1)
        return true;
      else if (y + 1 < grid[0].length && !visited[x][y + 1] && RIGHT.contains(grid[x][y])
          && LEFT.contains(grid[x][y + 1]))
        y++;
      else if (y - 1 >= 0 && !visited[x][y - 1] && LEFT.contains(grid[x][y])
          && RIGHT.contains(grid[x][y - 1]))
        y--;
      else if (x + 1 < grid.length && !visited[x + 1][y] && DOWN.contains(grid[x][y])
          && UP.contains(grid[x + 1][y]))
        x++;
      else if (x - 1 >= 0 && !visited[x - 1][y] && UP.contains(grid[x][y])
          && DOWN.contains(grid[x - 1][y]))
        x--;
      else
        break;
      visited[x][y] = true;
    }
    return false;
  }
}
