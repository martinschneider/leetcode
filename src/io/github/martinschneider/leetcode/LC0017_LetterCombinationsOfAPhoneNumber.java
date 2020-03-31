package io.github.martinschneider.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/letter-combinations-of-a-phone-number/
public class LC0017_LetterCombinationsOfAPhoneNumber {
  public List<String> letterCombinations(String digits) {
    if (digits.isEmpty())
      return Collections.emptyList();
    Map<Integer, List<Character>> letterMap = new HashMap<>();
    letterMap.put(2, List.of('a', 'b', 'c'));
    letterMap.put(3, List.of('d', 'e', 'f'));
    letterMap.put(4, List.of('g', 'h', 'i'));
    letterMap.put(5, List.of('j', 'k', 'l'));
    letterMap.put(6, List.of('m', 'n', 'o'));
    letterMap.put(7, List.of('p', 'q', 'r', 's'));
    letterMap.put(8, List.of('t', 'u', 'v'));
    letterMap.put(9, List.of('w', 'x', 'y', 'z'));
    List<String> results = new ArrayList<>();
    results.add("");
    for (char chr : digits.toCharArray()) {
      List<Character> letters = letterMap.get(Character.getNumericValue(chr));
      List<String> newResults = new ArrayList<>(results);
      for (String result : results) {
        for (Character letter : letters) {
          newResults.add(result + letter);
        }
        newResults.remove(result);
      }
      results = newResults;
    }
    return results;
  }
}
