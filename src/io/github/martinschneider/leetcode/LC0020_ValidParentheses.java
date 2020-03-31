package io.github.martinschneider.leetcode;

import java.util.Deque;
import java.util.LinkedList;

// https://leetcode.com/problems/valid-parentheses/
public class LC0020_ValidParentheses {
  public boolean isValid(String s) {
    Deque<Character> stack = new LinkedList<Character>();
    for (int i = 0, L = s.length(); i < L; i++) {
      char ch = s.charAt(i);
      if (ch == ')' || ch == ']' || ch == '}') {
        if (stack.isEmpty())
          return false;
        if (ch == ')' && stack.pop() != '(')
          return false;
        if (ch == ']' && stack.pop() != '[')
          return false;
        if (ch == '}' && stack.pop() != '{')
          return false;
      } else
        stack.push(ch);
    }
    return stack.isEmpty() ? true : false;
  }
}
