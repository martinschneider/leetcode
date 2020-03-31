package io.github.martinschneider.leetcode;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/check-if-n-and-its-double-exist/
public class LC1346_CheckIfNAndItsDoubleExist {
  public boolean checkIfExist(int[] arr) {
    Set<Integer> numbers = new HashSet<Integer>();
    for (int i = 0; i < arr.length; i++) {
      if (numbers.contains(arr[i] * 2) || (arr[i] % 2 == 0 && numbers.contains(arr[i] / 2)))
        return true;
      numbers.add(arr[i]);
    }
    return false;
  }
}
