package io.github.martinschneider.leetcode;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/cinema-seat-allocation/
public class LC1368_CinemaSeatAllocation {
  private static final int ONE_FAMILY_1 = 2 + 4 + 8 + 16;
  private static final int ONE_FAMILY_2 = 8 + 16 + 32 + 64;
  private static final int ONE_FAMILY_3 = 32 + 64 + 128 + 256;
  private static final int TWO_FAMILIES = 2 + 4 + 8 + 16 + 32 + 64 + 128 + 256;

  public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
    Map<Integer, Integer> rows = new HashMap<>();
    for (int i = 0; i < reservedSeats.length; i++) {
      if (!rows.containsKey(reservedSeats[i][0])) {
        rows.put(reservedSeats[i][0], 0);
      }
      rows.put(reservedSeats[i][0],
          rows.get(reservedSeats[i][0]) + (int) Math.pow(2, reservedSeats[i][1] - 1));
    }
    int families = 2 * (n - rows.size());
    for (int row : rows.values()) {
      if ((row & TWO_FAMILIES) == 0) {
        families += 2;
      } else if ((row & ONE_FAMILY_1) == 0 || (row & ONE_FAMILY_2) == 0
          || (row & ONE_FAMILY_3) == 0) {
        families++;
      }
    }
    return families;
  }
}
