package io.github.martinschneider.leetcode;

import java.util.concurrent.atomic.AtomicBoolean;

// https://leetcode.com/problems/print-in-order/
public class LC1114_PrintInOrder {
  AtomicBoolean first = new AtomicBoolean(false);
  AtomicBoolean second = new AtomicBoolean(false);

  public void first(Runnable printFirst) throws InterruptedException {

    // printFirst.run() outputs "first". Do not change or remove this line.
    printFirst.run();
    first.set(true);
  }

  public void second(Runnable printSecond) throws InterruptedException {

    // printSecond.run() outputs "second". Do not change or remove this line.
    while (first.get() == false) {
    }
    printSecond.run();
    second.set(true);
  }

  public void third(Runnable printThird) throws InterruptedException {

    // printThird.run() outputs "third". Do not change or remove this line.
    while (second.get() == false) {
    }
    printThird.run();
  }
}
