package io.github.martinschneider.leetcode;

// https://leetcode.com/problems/encode-number/
public class LC1256_EncodeNumber {
  public String encode(int num) {
    if (num == 0)
      return "";
    int digits = (int) (Math.log(num + 1) / Math.log(2));
    int count = (int) (num - Math.pow(2, digits) + 2);
    String str = Integer.toBinaryString(count - 1);
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < digits - str.length(); i++)
      sb.append('0');
    sb.append(str);
    return sb.toString();
  }
}
