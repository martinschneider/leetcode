package io.github.martinschneider.leetcode;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class LC0003_LongestSubstringWithoutRepeatingCharacters {
  public int lengthOfLongestSubstring(String s) {
    Set<String> characters = new HashSet<String>();
    int max = 0;
    for (int j = 0; j < s.length(); j++) {
      characters.clear();
      int localMax = 0;
      for (int i = j; i < s.length(); i++) {
        String character = s.substring(i, i + 1);
        if (characters.contains(character)) {
          break;
        } else {
          localMax++;
          characters.add(character);
        }
      }
      max = Math.max(max, localMax);
    }
    return max;
  }
}
