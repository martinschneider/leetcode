package io.github.martinschneider.leetcode;

import java.util.Deque;
import java.util.LinkedList;

// https://leetcode.com/problems/iterator-for-combination/
public class LC1286_IteratorForCombination {
  private Deque<String> permutations = new LinkedList<String>();

  public LC1286_IteratorForCombination(String characters, int combinationLength) {
    createPerms(new char[combinationLength], 0, 0, characters);
    System.out.println(permutations);
  }

  private void createPerms(char[] perm, int start, int pos, String str) {
    if (pos == perm.length) {
      if (!permutations.contains(new String(perm)))
        permutations.add(new String(perm));
    } else {
      for (int i = start; i < str.length(); i++) {
        perm[pos] = str.charAt(i);
        createPerms(perm, start++, pos + 1,
            str.substring(0, i) + str.substring(i + 1, str.length()));
      }
    }
  }

  public String next() {
    return permutations.remove();
  }

  public boolean hasNext() {
    return !permutations.isEmpty();
  }
}
