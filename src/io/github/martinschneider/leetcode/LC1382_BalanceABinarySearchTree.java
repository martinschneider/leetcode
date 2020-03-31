package io.github.martinschneider.leetcode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/balance-a-binary-search-tree/
public class LC1382_BalanceABinarySearchTree {
  public TreeNode balanceBST(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    traverse(root, list);
    return createBST(list, 0, list.size() - 1);
  }

  private void traverse(TreeNode node, List<Integer> list) {
    if (node.left != null)
      traverse(node.left, list);
    list.add(node.val);
    if (node.right != null)
      traverse(node.right, list);
  }

  private TreeNode createBST(List<Integer> list, int start, int end) {
    int mid = start + (end - start) / 2;
    TreeNode root = new TreeNode(list.get(mid));
    if (start != mid)
      root.left = createBST(list, start, mid - 1);
    if (start != end)
      root.right = createBST(list, mid + 1, end);
    return root;
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
