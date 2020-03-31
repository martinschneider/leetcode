package io.github.martinschneider.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

// https://leetcode.com/problems/min-stack/
public class LC0155_MinStack {
  Integer min = null;
  Deque<Integer> stack = new LinkedList<Integer>();
  PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();

  /** initialize your data structure here. */
  public LC0155_MinStack() {}

  public void push(int x) {
    stack.push(x);
    if (min == null || x < min.intValue())
      priorityQueue.offer(x);
  }

  public void pop() {
    if (stack.peek().intValue() == priorityQueue.peek().intValue()) {
      priorityQueue.poll();
    }
    stack.pop();
  }

  public int top() {
    return stack.peek();
  }

  public int getMin() {
    return priorityQueue.peek();
  }
}
