package io.github.martinschneider.leetcode;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/
public class LC1339_MaximumProductOfSplittedBinaryTree {
  private Set<Long> sums = new HashSet<>();

  public int maxProduct(TreeNode node) {
    long total = getSum(node);
    long max = 0;
    for (long sum : sums)
      max = Math.max(max, sum * (total - sum));
    return (int) (max % 1000000007);
  }

  private long getSum(TreeNode node) {
    if (node == null)
      return 0;
    node.val += getSum(node.left);
    node.val += getSum(node.right);
    sums.add((long) node.val);
    return node.val;
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
