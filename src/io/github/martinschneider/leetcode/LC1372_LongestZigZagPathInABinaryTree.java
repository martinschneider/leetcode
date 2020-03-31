package io.github.martinschneider.leetcode;

import java.util.Deque;
import java.util.LinkedList;

// https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/
public class LC1372_LongestZigZagPathInABinaryTree {
  public int longestZigZag(TreeNode root) {
    Deque<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    int max = 0;
    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();
      max = Math.max(max, Math.max(check(node, true), check(node, false)));
      if (node.left != null) {
        queue.offer(node.left);
      }
      if (node.right != null) {
        queue.offer(node.right);
      }
    }
    return max;
  }

  private int check(TreeNode node, boolean left) {
    if (left && node.val != -1 && node.val != -3) {
      if (node.val == -2)
        node.val = -3;
      else
        node.val = -1;
      if (node.left != null)
        return 1 + check(node.left, false);
    } else if (!left && node.val != -2 && node.val != -3) {
      if (node.val == -1)
        node.val = -3;
      else
        node.val = -2;
      if (node.right != null)
        return 1 + check(node.right, true);
    }
    return 0;
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
