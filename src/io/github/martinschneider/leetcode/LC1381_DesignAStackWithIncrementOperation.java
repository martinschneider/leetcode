package io.github.martinschneider.leetcode;

// https://leetcode.com/problems/design-a-stack-with-increment-operation/
public class LC1381_DesignAStackWithIncrementOperation {
  private int[] stack;
  private int maxSize;
  private int size;

  public LC1381_DesignAStackWithIncrementOperation(int maxSize) {
    this.stack = new int[maxSize];
    this.maxSize = maxSize;
  }

  public void push(int x) {
    if (size < maxSize) {
      stack[size] = x;
      size++;
    }
  }

  public int pop() {
    if (size == 0)
      return -1;
    size--;
    return stack[size];
  }

  public void increment(int k, int val) {
    for (int i = 0; i < k && i < maxSize; i++) {
      stack[i] += val;
    }
  }
}
