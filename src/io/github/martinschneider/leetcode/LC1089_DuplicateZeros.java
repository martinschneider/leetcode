package io.github.martinschneider.leetcode;

import java.util.Deque;
import java.util.LinkedList;

// https://leetcode.com/problems/duplicate-zeros/
public class LC1089_DuplicateZeros {
  public void duplicateZeros(int[] arr) {
    Deque<Integer> queue = new LinkedList<>();
    for (int i = 0; i < arr.length; i++) {
      queue.offer(arr[i]);
      if (arr[i] == 0) {
        queue.offer(0);
      }
      arr[i] = queue.poll();
    }
  }
}
