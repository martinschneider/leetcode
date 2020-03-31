package io.github.martinschneider.leetcode;

// https://leetcode.com/problems/maximum-69-number/
public class LC1323_Maximum69Number {
  public int maximum69Number(int num) {
    String s = Integer.toString(num);
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '6') {
        result.append('9');
        for (int j = i + 1; j < s.length(); j++) {
          result.append(s.charAt(j));
        }
        break;
      } else {
        result.append('9');
      }
    }
    return Integer.parseInt(result.toString());
  }
}
