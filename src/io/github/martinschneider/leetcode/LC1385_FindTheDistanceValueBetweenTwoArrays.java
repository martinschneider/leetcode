package io.github.martinschneider.leetcode;

// https://leetcode.com/problems/find-the-distance-value-between-two-arrays/
public class LC1385_FindTheDistanceValueBetweenTwoArrays {
  public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
    int distance = 0;
    for (int i = 0; i < arr1.length; i++) {
      boolean smallerDistance = false;
      for (int j = 0; j < arr2.length; j++) {
        if (Math.abs(arr1[i] - arr2[j]) <= d) {
          smallerDistance = true;
          break;
        }
      }
      if (!smallerDistance) {
        distance++;
      }
    }
    return distance;
  }
}
