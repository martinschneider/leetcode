package io.github.martinschneider.leetcode;

// https://leetcode.com/problems/delete-leaves-with-a-given-value/
public class LC1325_DeleteLeavesWithAGivenValue {
  private int deleted = -1;

  public TreeNode removeLeafNodes(TreeNode root, int target) {
    dfs(root, target);
    if (root.val == deleted) {
      return null;
    }
    return root;
  }

  private void dfs(TreeNode node, int target) {
    if (node == null) {
      return;
    }
    dfs(node.left, target);
    dfs(node.right, target);
    if (node.left != null && node.left.val == deleted) {
      node.left = null;
    }
    if (node.right != null && node.right.val == deleted) {
      node.right = null;
    }
    if (node.left == null && node.right == null && node.val == target) {
      node.val = deleted;
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
