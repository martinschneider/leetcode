package io.github.martinschneider.leetcode;

// https://leetcode.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/
public class LC1343_NumberOfSubArraysOfSizeKAndAverageGreaterThanOrEqualToThreshold {
  public int numOfSubarrays(int[] arr, int k, int threshold) {
    int[] sums = new int[arr.length - k + 1];
    int count = 0;
    for (int i = 0; i < k; i++) {
      sums[0] += arr[i];
    }
    if ((double) sums[0] / k >= threshold)
      count++;
    for (int i = 1; i < arr.length - k + 1; i++) {
      sums[i] = sums[i - 1] - arr[i - 1] + arr[i + k - 1];
      if ((double) sums[i] / k >= threshold)
        count++;
    }
    return count;
  }
}
