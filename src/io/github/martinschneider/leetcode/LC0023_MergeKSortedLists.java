package io.github.martinschneider.leetcode;

import java.util.PriorityQueue;

// https://leetcode.com/problems/merge-k-sorted-lists/
public class LC0023_MergeKSortedLists {
  public ListNode mergeKLists(ListNode[] lists) {
    if (lists.length == 0) {
      return null;
    }
    PriorityQueue<ListNode> pq = new PriorityQueue<>((ListNode o1, ListNode o2) -> o1.val - o2.val);
    for (int i = 0; i < lists.length; i++) {
      if (lists[i] != null) {
        pq.offer(lists[i]);
      }
    }
    ListNode head = pq.poll();
    ListNode prev = head;
    while (!pq.isEmpty()) {
      ListNode next = pq.poll();
      if (next.next != null) {
        pq.offer(next.next);
      }
      while (prev.next != null && prev.next.val < next.val) {
        prev = prev.next;
      }
      next.next = prev.next;
      prev.next = next;
      prev = next;
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
