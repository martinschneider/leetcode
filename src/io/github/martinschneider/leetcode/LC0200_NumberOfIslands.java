package io.github.martinschneider.leetcode;

import java.util.Deque;
import java.util.LinkedList;

// https://leetcode.com/problems/number-of-islands/
public class LC0200_NumberOfIslands {
  public int numIslands(char[][] grid) {
    int components = 0;
    Deque<Point> stack = new LinkedList<>();
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == '1') {
          stack.offer(new Point(i, j));
          while (!stack.isEmpty()) {
            scout(grid, stack);
          }
          components++;
        }
      }
    }
    return components;
  }

  private void scout(char[][] grid, Deque<Point> stack) {
    Point p = stack.poll();
    int i = p.x;
    int j = p.y;
    grid[i][j] = '0';
    if (i - 1 >= 0 && grid[i - 1][j] == '1')
      stack.offer(new Point(i - 1, j));
    if (i + 1 < grid.length && grid[i + 1][j] == '1')
      stack.offer(new Point(i + 1, j));
    if (j - 1 >= 0 && grid[i][j - 1] == '1')
      stack.offer(new Point(i, j - 1));
    if (j + 1 < grid[0].length && grid[i][j + 1] == '1')
      stack.offer(new Point(i, j + 1));
  }

  class Point {
    int x;
    int y;

    Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}
