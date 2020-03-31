package io.github.martinschneider.leetcode;

// https://leetcode.com/problems/add-two-numbers/
public class LC0002_AddTwoNumbers {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode result = new ListNode(-1);
    ListNode tmpNode = result;
    int carry = 0;
    while (l1 != null || l2 != null || carry != 0) {
      if (tmpNode.val != -1) {
        tmpNode.next = new ListNode(-1);
        tmpNode = tmpNode.next;
      }
      int num1 = (l1 != null) ? l1.val : 0;
      int num2 = (l2 != null) ? l2.val : 0;
      int digit = num1 + num2 + carry;
      if (digit >= 10) {
        carry = digit / 10;
        digit %= 10;
      } else {
        carry = 0;
      }
      tmpNode.val = digit;
      l1 = (l1 != null) ? l1.next : l1;
      l2 = (l2 != null) ? l2.next : l2;
    }
    return result;
  }

  class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
      val = x;
    }
  }
}
