package io.github.martinschneider.leetcode;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/copy-list-with-random-pointer/
public class LC0138_CopyListWithRandomPointer {
  private Map<Node, Node> copies = new HashMap<Node, Node>();

  public Node copyRandomList(Node head) {
    if (head == null)
      return null;
    if (copies.containsKey(head)) {
      return copies.get(head);
    } else {
      Node node = new Node(head.val, null, null);
      copies.put(head, node);
      node.next = copyRandomList(head.next);
      node.random = copyRandomList(head.random);
      return node;
    }
  }

  class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val, Node _next, Node _random) {
      val = _val;
      next = _next;
      random = _random;
    }
  };
}
