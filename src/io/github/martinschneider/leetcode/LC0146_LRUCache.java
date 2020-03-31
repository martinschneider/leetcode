package io.github.martinschneider.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

// https://leetcode.com/problems/lru-cache/
public class LC0146_LRUCache {

  private Map<Integer, Integer> cache;
  private LinkedList<Integer> pq;
  private int capacity;

  public LC0146_LRUCache(int capacity) {
    this.capacity = capacity;
    this.cache = new HashMap<>();
    this.pq = new LinkedList<>();
  }

  public int get(int key) {
    if (cache.containsKey(key)) {
      pq.remove(Integer.valueOf(key));
      pq.add(key);
      return cache.get(key);
    }
    return -1;
  }

  public void put(int key, int value) {
    cache.put(key, value);
    if (cache.containsKey(key))
      pq.remove(Integer.valueOf(key));
    pq.add(key);
    if (cache.size() > capacity)
      cache.remove(pq.poll());
  }
}
