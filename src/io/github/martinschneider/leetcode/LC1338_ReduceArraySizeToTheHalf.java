package io.github.martinschneider.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

// https://leetcode.com/problems/reduce-array-size-to-the-half/
public class LC1338_ReduceArraySizeToTheHalf {
  public int minSetSize(int[] arr) {
    PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
    Arrays.sort(arr);
    int currNumber = arr[0];
    int count = 1;
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] == currNumber) {
        count++;
      } else {
        queue.add(count);
        currNumber = arr[i];
        count = 1;
      }
    }
    queue.add(count);
    int toRemove = arr.length / 2;
    count = 0;
    while (toRemove > 0) {
      toRemove -= queue.poll();
      count++;
    }
    return count;
  }
}
