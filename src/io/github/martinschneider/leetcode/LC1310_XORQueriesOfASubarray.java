package io.github.martinschneider.leetcode;

// https://leetcode.com/problems/xor-queries-of-a-subarray/
public class LC1310_XORQueriesOfASubarray {
  public int[] xorQueries(int[] arr, int[][] queries) {
    int[] results = new int[queries.length];
    for (int j = 0; j < queries.length; j++) {
      int result = arr[queries[j][0]];
      for (int i = queries[j][0] + 1; i <= queries[j][1]; i++) {
        result ^= arr[i];
      }
      results[j] = result;
    }
    return results;
  }
}
