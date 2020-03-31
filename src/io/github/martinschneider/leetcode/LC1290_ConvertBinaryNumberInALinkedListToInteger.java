package io.github.martinschneider.leetcode;

// https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
public class LC1290_ConvertBinaryNumberInALinkedListToInteger {
  public int getDecimalValue(ListNode head) {
    StringBuilder str = new StringBuilder();
    while (head != null) {
      str.append(head.val);
      head = head.next;
    }
    return Integer.parseInt(str.toString(), 2);
  }

  class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }
}
