package io.github.martinschneider.leetcode;

import java.util.List;
import java.util.stream.Collectors;

// https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/
public class LC1160_FindWordsThatCanBeFormedByCharacters {
  public int countCharacters(String[] words, String chars) {
    int count = 0;
    for (String word : words) {
      boolean match = true;
      List<Character> alphabet = chars.chars().mapToObj(e -> (char) e).collect(Collectors.toList());
      for (char chr : word.toCharArray()) {
        if (alphabet.contains(chr)) {
          alphabet.remove(Character.valueOf(chr));
        } else {
          match = false;
          break;
        }
      }
      if (match)
        count += word.length();
    }
    return count;
  }
}
