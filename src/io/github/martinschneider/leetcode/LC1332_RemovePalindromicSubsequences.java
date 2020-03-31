package io.github.martinschneider.leetcode;

// https://leetcode.com/problems/remove-palindromic-subsequences/
public class LC1332_RemovePalindromicSubsequences {
  public int removePalindromeSub(String s) {
    if (s.isEmpty()) {
      return 0;
    }
    return (isPalindrome(s)) ? 1 : 2;
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
