package io.github.martinschneider.leetcode;

// https://leetcode.com/problems/remove-vowels-from-a-string/
public class LC1119_RemoveVowelsFromAString {
  public String removeVowels(String s) {
    StringBuilder strBuilder = new StringBuilder();
    for (char chr : s.toCharArray()) {
      if (chr != 'a' && chr != 'e' && chr != 'i' && chr != 'o' && chr != 'u') {
        strBuilder.append(chr);
      }
    }
    return strBuilder.toString();
  }
}
