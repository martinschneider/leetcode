package io.github.martinschneider.leetcode;

// https://leetcode.com/problems/minimum-time-visiting-all-points/
public class LC1266_MinimumTimeVisitingAllPoints {
  public int minTimeToVisitAllPoints(int[][] points) {
    int time = 0;
    for (int i = 0; i < points.length - 1; i++) {
      time += shortestPath(points[i][0], points[i][1], points[i + 1][0], points[i + 1][1]);
    }
    return time;
  }

  private int shortestPath(int currX, int currY, int nextX, int nextY) {
    int diffX = Math.abs(currX - nextX);
    int diffY = Math.abs(currY - nextY);
    return Math.min(diffX, diffY) + Math.abs(diffX - diffY);
  }
}
