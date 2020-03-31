package io.github.martinschneider.leetcode;

import java.util.AbstractMap.SimpleEntry;
import java.util.Comparator;
import java.util.PriorityQueue;

// https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/
public class LC1337_TheKWeakestRowsInAMatrix {
  public int[] kWeakestRows(int[][] mat, int k) {
    PriorityQueue<SimpleEntry<Integer, Integer>> queue =
        new PriorityQueue<>(new Comparator<SimpleEntry<Integer, Integer>>() {
          public int compare(SimpleEntry<Integer, Integer> a, SimpleEntry<Integer, Integer> b) {
            int result = (Integer) a.getValue() - (Integer) b.getValue();
            return (result == 0) ? (Integer) a.getKey() - (Integer) b.getKey() : result;
          }
        });
    for (int i = 0; i < mat.length; i++) {
      int sum = 0;
      for (int j = 0; j < mat[i].length; j++) {
        sum += mat[i][j];
      }
      queue.add(new SimpleEntry<Integer, Integer>(i, sum));
    }
    int[] result = new int[k];
    for (int i = 0; i < k; i++) {
      result[i] = queue.poll().getKey();
    }
    return result;
  }
}
