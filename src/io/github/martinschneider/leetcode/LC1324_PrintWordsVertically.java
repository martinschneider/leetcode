package io.github.martinschneider.leetcode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/print-words-vertically/
public class LC1324_PrintWordsVertically {
  public List<String> printVertically(String s) {
    List<String> result = new ArrayList<>();
    String[] words = s.split(" ");
    for (int i = 0; i < words.length; i++) {
      for (int j = 0; j < words[i].length(); j++) {
        if (result.size() <= j) {
          result.add("");
        }
        result.set(j, appendSpaces(result.get(j), i) + words[i].substring(j, j + 1));
      }
    }
    return result;
  }

  private String appendSpaces(String current, int i) {
    int spaces = i - current.length();
    if (spaces <= 0) {
      return current;
    } else {
      StringBuilder strBuilder = new StringBuilder(current);
      for (int k = 0; k < spaces; k++) {
        strBuilder.append(' ');
      }
      return strBuilder.toString();
    }
  }
}
