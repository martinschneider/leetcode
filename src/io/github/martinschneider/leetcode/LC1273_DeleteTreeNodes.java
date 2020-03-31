package io.github.martinschneider.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/delete-tree-nodes/
public class LC1273_DeleteTreeNodes {
  public int deleteTreeNodes(int nodes, int[] parent, int[] value) {
    Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
    for (int i = 0; i < nodes; i++) {
      map.put(i, new ArrayList<Integer>());
    }
    int[] nodeSum = new int[nodes];
    nodeSum[0] = value[0];
    for (int i = 1; i < nodes; i++) {
      int j = i;
      while (j != -1) {
        nodeSum[j] += value[i];
        j = parent[j];
      }
      map.get(parent[i]).add(i);
    }
    for (int i = 0; i < nodes; i++) {
      if (nodeSum[i] == 0) {
        for (int j : map.get(i)) {
          nodeSum[j] = 0;
        }
      } else {
        nodeSum[i] = 1;
      }
    }
    int result = 0;
    for (int i = 0; i < nodes; i++) {
      result += nodeSum[i];
    }
    return result;
  }
}
