package io.github.martinschneider.leetcode;

import java.util.AbstractMap.SimpleEntry;
import java.util.Deque;
import java.util.LinkedList;

// https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/
public class LC1161_MaximumLevelSumOfABinaryTree {

  public int maxLevelSum(TreeNode root) {
    Deque<SimpleEntry<TreeNode, Integer>> queue = new LinkedList<>();
    queue.offer(new SimpleEntry<TreeNode, Integer>(root, 1));
    int currLevel = 0;
    int currSum = 0;
    int maxSum = 0;
    int maxLevel = 0;
    while (!queue.isEmpty()) {
      SimpleEntry<TreeNode, Integer> pair = queue.poll();
      TreeNode node = pair.getKey();
      int level = pair.getValue();
      if (level > currLevel) {
        if (currSum > maxSum) {
          maxLevel = currLevel;
          maxSum = currSum;
        }
        currLevel = level;
        currSum = 0;
      }
      currSum += node.val;
      if (node.left != null)
        queue.offer(new SimpleEntry<TreeNode, Integer>(node.left, level + 1));
      if (node.right != null)
        queue.offer(new SimpleEntry<TreeNode, Integer>(node.right, level + 1));
    }
    return maxLevel;
  }

  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
}
