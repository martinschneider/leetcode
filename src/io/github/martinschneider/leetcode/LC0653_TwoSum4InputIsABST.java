package io.github.martinschneider.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
public class LC0653_TwoSum4InputIsABST {
  public boolean findTarget(TreeNode root, int k) {
    List<Integer> numbers = new ArrayList<>();
    Deque<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      TreeNode curr = queue.pop();
      if (numbers.contains(k - curr.val))
        return true;
      numbers.add(curr.val);
      if (curr.left != null)
        queue.offer(curr.left);
      if (curr.right != null)
        queue.offer(curr.right);
    }
    return false;
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
