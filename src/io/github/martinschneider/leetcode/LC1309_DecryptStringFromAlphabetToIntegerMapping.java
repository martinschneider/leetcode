package io.github.martinschneider.leetcode;

// https://leetcode.com/problems/decrypt-string-from-alphabet-to-integer-mapping/
public class LC1309_DecryptStringFromAlphabetToIntegerMapping {
  public String freqAlphabets(String s) {
    StringBuilder result = new StringBuilder();
    char store1 = '\u0000';
    char store2 = '\u0000';
    for (Character chr : s.toCharArray()) {
      if (chr == '#') {
        appendChar(Character.getNumericValue(store1) * 10 + Character.getNumericValue(store2),
            result);
        store1 = '\u0000';
        store2 = '\u0000';
      } else {
        if (store1 != '\u0000') {
          appendChar(Character.getNumericValue(store1), result);
        }
        store1 = store2;
        store2 = chr;
      }
    }
    if (store1 != '\u0000') {
      appendChar(Character.getNumericValue(store1), result);
    }
    if (store2 != '\u0000') {
      appendChar(Character.getNumericValue(store2), result);
    }
    return result.toString();
  }

  private void appendChar(int idx, StringBuilder strBuilder) {
    idx = 96 + idx;
    strBuilder.append((char) idx);
  }
}
