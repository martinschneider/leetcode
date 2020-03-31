package io.github.martinschneider.leetcode;

import java.util.Deque;
import java.util.LinkedList;

// https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/
public class LC1379_FindACorrespondingNodeOfABinaryTreeInACloneOfThatTree {
  public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned,
      final TreeNode target) {
    Deque<TreeNode> originalQueue = new LinkedList<>();
    Deque<TreeNode> clonedQueue = new LinkedList<>();
    originalQueue.offer(original);
    clonedQueue.offer(cloned);
    while (!originalQueue.isEmpty()) {
      TreeNode curr1 = originalQueue.poll();
      TreeNode curr2 = clonedQueue.poll();
      if (curr1.equals(target)) {
        return curr2;
      }
      if (curr1.left != null) {
        originalQueue.offer(curr1.left);
        clonedQueue.offer(curr2.left);
      }
      if (curr1.right != null) {
        originalQueue.offer(curr1.right);
        clonedQueue.offer(curr2.right);
      }
    }
    return null;
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
