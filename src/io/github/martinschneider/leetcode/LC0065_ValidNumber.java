package io.github.martinschneider.leetcode;

public class LC0065_ValidNumber {
  public boolean isNumber(String s) {
    s = s.trim();
    return !s.isEmpty() && !s.equals(".") && !s.equals("-.")
        && s.length() == nr(s, sgn(s, exp(s, nr(s, dp(s, nr(s, sgn(s, 0)))))));
  }

  private int sgn(String s, int idx) {
    if (idx < 0 || idx >= s.length())
      return idx;
    if (s.charAt(idx) == '-' || s.charAt(idx) == '+') {
      if (idx == s.length() - 1)
        return -1;
      if (idx != 0 && (s.indexOf('e') == -1 || s.indexOf('e') > idx))
        return -1;
      return ++idx;
    }
    return idx;
  }

  private int nr(String s, int idx) {
    if (idx < 0 || idx >= s.length())
      return idx;
    while (idx < s.length() && Character.isDigit(s.charAt(idx))) {
      idx++;
    }
    return idx;
  }

  private int dp(String s, int idx) {
    if (idx < 0 || idx >= s.length())
      return idx;
    return (s.charAt(idx) == '.') ? ++idx : idx;
  }

  private int exp(String s, int idx) {
    if (idx < 0 || idx >= s.length())
      return idx;
    if (s.charAt(idx) == 'e') {
      if (idx == 0)
        return -1;
      if (idx == 1 && (s.charAt(0) == '.' || s.charAt(0) == '-' || s.charAt(0) == '+'))
        return -1;
      if (sgn(s, nr(s, ++idx)) == idx)
        return -1;
    }
    return idx;
  }
}
