package io.github.martinschneider.leetcode;

import java.util.Arrays;

// https://leetcode.com/problems/increasing-decreasing-string/
public class LC1370_IncreasingDecreasingString {
  public String sortString(String s) {
    if (s.length() == 0)
      return s;
    char[] array = s.toCharArray();
    Arrays.sort(array);
    StringBuilder result = new StringBuilder();
    while (array.length > 0) {
      int i = 0;
      while (i != -1) {
        result.append(array[i]);
        char curr = array[i];
        array = remove(array, i);
        i = findNext(array, i, 1, curr);
      }
      i = array.length - 1;
      while (i != -1) {
        result.append(array[i]);
        char curr = array[i];
        array = remove(array, i);
        i = findNext(array, i - 1, -1, curr);
      }
    }
    return result.toString();
  }

  private int findNext(char[] array, int start, int offset, char curr) {
    while (start >= 0 && start < array.length) {
      if (array[start] != curr && array[start] != '-') {
        return start;
      }
      start += offset;
    }
    return -1;
  }

  private char[] remove(char[] array, int idx) {
    char[] result = new char[array.length - 1];
    for (int i = 0; i < idx; i++) {
      result[i] = array[i];
    }
    for (int i = idx + 1; i < array.length; i++) {
      result[i - 1] = array[i];
    }
    return result;
  }
}
