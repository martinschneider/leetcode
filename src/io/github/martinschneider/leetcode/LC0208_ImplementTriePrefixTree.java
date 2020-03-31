package io.github.martinschneider.leetcode;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/implement-trie-prefix-tree/
public class LC0208_ImplementTriePrefixTree {
  private Map<Character, TrieNode> map = new HashMap<>();

  public LC0208_ImplementTriePrefixTree() {

  }

  public void insert(String word) {
    Map<Character, TrieNode> curr = map;
    TrieNode trieNode = null;
    for (char chr : word.toCharArray()) {
      if (!curr.containsKey(chr))
        curr.put(chr, new TrieNode());
      trieNode = curr.get(chr);
      curr = trieNode.map;
    }
    trieNode.isValue = true;
  }

  public boolean search(String word) {
    return exists(word, true);
  }

  public boolean startsWith(String prefix) {
    return exists(prefix, false);
  }

  private boolean exists(String word, boolean asWord) {
    Map<Character, TrieNode> curr = map;
    TrieNode trieNode = null;
    for (char chr : word.toCharArray()) {
      if (!curr.containsKey(chr))
        return false;
      trieNode = curr.get(chr);
      if (trieNode == null)
        return false;
      curr = trieNode.map;
    }
    if (asWord)
      return trieNode.isValue;
    return true;
  }
}


class TrieNode {
  public boolean isValue;
  public Map<Character, TrieNode> map = new HashMap<>();
}
