package io.github.martinschneider.leetcode;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/find-elements-in-a-contaminated-binary-tree/
public class LC1261_FindElementsInAContaminatedBinaryTree {
  private Set<Integer> search = new HashSet<Integer>();

  public LC1261_FindElementsInAContaminatedBinaryTree(TreeNode root) {
      root.val=0;
      recover(root);
  }

  public boolean find(int target) {
    return search.contains(target);
  }

  private void recover(TreeNode node) {
    int value = 0;
    if (node.left != null) {
      value = 2 * node.val + 1;
      search.add(value);
      node.left.val = value;
      recover(node.left);
    }
    if (node.right != null) {
      value = 2 * node.val + 2;
      node.right.val = value;
      search.add(value);
      recover(node.right);
    }
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
