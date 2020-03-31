package io.github.martinschneider.leetcode;

import java.util.Deque;
import java.util.LinkedList;

// https://leetcode.com/problems/rotting-oranges/
public class LC0994_RottingOranges {
  public int orangesRotting(int[][] grid) {
    int time = 0;
    boolean done = true;
    Deque<int[]> queue = new LinkedList<>();
    while (true) {
      done = true;
      for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[i].length; j++) {
          if (grid[i][j] == 2) {
            enqeueNeighbours(queue, grid, i, j);
          } else if (grid[i][j] == 1) {
            done = false;
          }
        }
      }
      if (queue.isEmpty())
        break;
      while (!queue.isEmpty()) {
        int[] coord = queue.poll();
        grid[coord[0]][coord[1]] = 2;
      }
      time++;
    }
    return (done) ? time : -1;
  }

  private void enqeueNeighbours(Deque<int[]> queue, int[][] grid, int i, int j) {
    if (i > 0 && grid[i - 1][j] == 1) {
      queue.offer(new int[] {i - 1, j});
    }
    if (i < grid.length - 1 && grid[i + 1][j] == 1) {
      queue.offer(new int[] {i + 1, j});
    }
    if (j > 0 && grid[i][j - 1] == 1) {
      queue.offer(new int[] {i, j - 1});
    }
    if (j < grid[i].length - 1 && grid[i][j + 1] == 1) {
      queue.offer(new int[] {i, j + 1});
    }
  }
}
