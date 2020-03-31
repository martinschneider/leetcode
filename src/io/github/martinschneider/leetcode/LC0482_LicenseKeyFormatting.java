package io.github.martinschneider.leetcode;

// https://leetcode.com/problems/license-key-formatting/
public class LC0482_LicenseKeyFormatting {
  public String licenseKeyFormatting(String s, int k) {
    s = s.replaceAll("-", "");
    s = s.toUpperCase();
    int groups = s.length() / k;
    int k1 = s.length() % k;
    StringBuilder strBuilder = new StringBuilder();
    int idx = 0;
    if (k1 > 0) {
      strBuilder.append(s.substring(idx, idx + k1));
      idx += k1;
    }
    for (int i = 1; i <= groups; i++) {
      if (i > 1 || k1 > 0) {
        strBuilder.append('-');
      }
      strBuilder.append(s.substring(idx, idx + k));
      idx += k;
    }
    return strBuilder.toString();
  }
}
