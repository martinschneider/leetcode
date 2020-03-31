package io.github.martinschneider.leetcode;

// https://leetcode.com/problems/remove-nth-node-from-end-of-list/
public class LC0019_RemoveNthNodeFromEndOfList {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode p1 = head;
    ListNode p2 = head;
    int count = 0;
    for (int i = 1; i <= n + 1; i++) {
      if (p1 != null) {
        p1 = p1.next;
        count++;
      }
    }
    while (p1 != null) {
      count++;
      p1 = p1.next;
      p2 = p2.next;
    }
    if (count == n) {
      head = head.next;
    } else {
      p2.next = p2.next.next;
    }
    return head;
  }

  class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }
}
