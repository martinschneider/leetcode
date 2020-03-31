package io.github.martinschneider.leetcode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/number-of-burgers-with-no-waste-of-ingredients/
public class LC1276_NumberOfBurgersWithNoWasteOfIngredients {
  public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
    List<Integer> result = new ArrayList<>();
    if (tomatoSlices == 0 && cheeseSlices == 0) {
      result.add(0);
      result.add(0);
      return result;
    }
    if (cheeseSlices > tomatoSlices || tomatoSlices % 2 != 0) {
      return result;
    }
    // jumbos+smalls=cheeseSlices
    int jumbos = 0;
    int smalls = tomatoSlices / 2;
    if (tomatoSlices / 2 == cheeseSlices) {
      result.add(jumbos);
      result.add(smalls);
      return result;
    }
    while (smalls > 0) {
      jumbos++;
      smalls -= 2;
      if (jumbos + smalls == cheeseSlices) {
        result.add(jumbos);
        result.add(smalls);
        break;
      }
    }
    return result;
  }
}
