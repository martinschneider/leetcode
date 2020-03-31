package io.github.martinschneider.leetcode;

// https://leetcode.com/problems/minimum-flips-to-make-a-or-b-equal-to-c/
public class LC1318_MinimumFlipsToMakeA_OR_BEqualToC {
  public int minFlips(int a, int b, int c) {
    String strA = Integer.toBinaryString(a);
    String strB = Integer.toBinaryString(b);
    String strC = Integer.toBinaryString(c);
    int length = Math.max(Math.max(strA.length(), strB.length()), strC.length());
    strA = String.format("%1$" + length + "s", strA).replace(' ', '0');
    strB = String.format("%1$" + length + "s", strB).replace(' ', '0');
    strC = String.format("%1$" + length + "s", strC).replace(' ', '0');
    int switches = 0;
    for (int i = 0; i < length; i++) {
      boolean boolA = strA.substring(i, i + 1).equals("1");
      boolean boolB = strB.substring(i, i + 1).equals("1");
      boolean boolC = strC.substring(i, i + 1).equals("1");
      if ((boolA || boolB) != boolC) {
        if (boolA && boolB)
          switches += 2;
        else
          switches++;
      }
    }
    return switches;
  }
}
