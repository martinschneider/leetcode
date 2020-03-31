package io.github.martinschneider.leetcode;

// https://leetcode.com/problems/longest-palindromic-substring/
public class LC0005_LongestPalindromicSubstring {
  public String longestPalindrome(String s) {
    String longest = "";
    for (int i = 0; i <= s.length(); i++) {
      for (int j = i; j <= s.length(); j++) {
        if (isPalindrome(s.substring(i, j)) && j - i > longest.length()) {
          longest = s.substring(i, j);
        }
      }
    }
    return longest;
  }

  private boolean isPalindrome(String s) {
    for (int i = 0; i < s.length() / 2; i++) {
      if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
        return false;
      }
    }
    return true;
  }
}
