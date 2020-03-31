package io.github.martinschneider.leetcode;

// https://leetcode.com/problems/merge-two-sorted-lists/
public class LC0021_MergeTwoSortedLists {
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null) {
      return l2;
    }
    if (l2 == null) {
      return l1;
    }
    ListNode head = null;
    if (l1.val <= l2.val) {
      head = l1;
      l1 = l1.next;
    } else {
      head = l2;
      l2 = l2.next;
    }
    ListNode curr = head;
    while (l1 != null || l2 != null) {
      if (l1 == null) {
        curr.next = l2;
        curr = curr.next;
        l2 = l2.next;
      } else if (l2 == null) {
        curr.next = l1;
        curr = curr.next;
        l1 = l1.next;
      } else if (l1.val <= l2.val) {
        curr.next = l1;
        curr = curr.next;
        l1 = l1.next;
      } else {
        curr.next = l2;
        curr = curr.next;
        l2 = l2.next;
      }
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
