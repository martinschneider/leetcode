package io.github.martinschneider.leetcode;

// https://leetcode.com/problems/hexspeak/
public class LC1271_Hexspeak {
  public String toHexspeak(String num) {
    String result =
        Long.toHexString(Long.parseLong(num)).replace("1", "I").replace("0", "O").toUpperCase();
    if (result.matches("^.*?(2|3|4|5|6|7|8|9).*$"))
      return "ERROR";
    return result;
  }
}
