package io.github.martinschneider.leetcode;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/
public class LC1347_MinimumNumberOfStepsToMakeTwoStringsAnagram {
  public int minSteps(String s, String t) {
    Map<Character, Integer> letters = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      updateCount(s.charAt(i), 1, letters);
      updateCount(t.charAt(i), -1, letters);
    }
    int count = 0;
    for (Map.Entry<Character, Integer> entry : letters.entrySet()) {
      int value = (int) entry.getValue();
      if (value > 0)
        count += value;
    }
    return count;
  }

  private void updateCount(char chr, int change, Map<Character, Integer> letters) {
    int count = letters.containsKey(chr) ? letters.get(chr) : 0;
    letters.put(chr, count + change);
  }
}
