package io.github.martinschneider.leetcode;

// https://leetcode.com/problems/generate-a-string-with-characters-that-have-odd-counts/
public class LC1374_GenerateAStringWithCharactersThatHaveOddCounts {
  public String generateTheString(int n) {
    StringBuilder strBuilder = new StringBuilder();
    for (int i = 1; i <= n - 1; i++) {
      strBuilder.append('a');
    }
    if (n % 2 == 0) {
      strBuilder.append('b');
    } else {
      strBuilder.append('a');
    }
    return strBuilder.toString();
  }
}
