package io.github.martinschneider.leetcode;

import java.util.Deque;
import java.util.LinkedList;

// https://leetcode.com/problems/print-immutable-linked-list-in-reverse/
public class LC1265_PrintImmutableLinkedListInReverse {
  public void printLinkedListInReverse(ImmutableListNode head) {
    Deque<ImmutableListNode> stack = new LinkedList<>();
    while (head != null) {
      stack.push(head);
      head = head.getNext();
    }
    while (!stack.isEmpty()) {
      stack.pop().printValue();
    }
  }

  interface ImmutableListNode {
    public void printValue(); // print the value of this node.

    public ImmutableListNode getNext(); // return the next node.
  };
}
