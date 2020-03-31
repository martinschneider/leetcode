package io.github.martinschneider.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/binary-tree-right-side-view/
public class LC0199_BinaryTreeRightSideView {
  private Map<Integer, Integer> map = new HashMap<Integer, Integer>();

  public List<Integer> rightSideView(TreeNode root) {
    inorder(root, 0);
    return new ArrayList<Integer>(map.values());
  }

  private void inorder(TreeNode node, int level) {
    if (node != null) {
      inorder(node.right, level + 1);
      if (map.get(level) == null)
        map.put(level, node.val);
      inorder(node.left, level + 1);
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
