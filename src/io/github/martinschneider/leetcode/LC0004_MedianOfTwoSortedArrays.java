package io.github.martinschneider.leetcode;

// https://leetcode.com/problems/median-of-two-sorted-arrays/
public class LC0004_MedianOfTwoSortedArrays {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    if (nums1.length == 0) {
      return getMedian(nums2);
    } else if (nums2.length == 0) {
      return getMedian(nums1);
    }
    int[] combined = new int[(nums1.length + nums2.length) / 2 + 1];
    int p1 = 0;
    int p2 = 0;
    for (int i = 0; i < combined.length; i++) {
      if (p1 >= nums1.length) {
        combined[i] = nums2[p2];
        p2++;
      } else if (p2 >= nums2.length || nums1[p1] <= nums2[p2]) {
        combined[i] = nums1[p1];
        p1++;
      } else {
        combined[i] = nums2[p2];
        p2++;
      }
    }
    if ((nums1.length + nums2.length) % 2 == 0) {
      return (double) (combined[combined.length - 2] + combined[combined.length - 1]) / 2;
    } else {
      return combined[combined.length - 1];
    }
  }

  private double getMedian(int[] array) {
    if (array.length % 2 == 0) {
      return (double) (array[array.length / 2 - 1] + array[array.length / 2]) / 2;
    } else {
      return array[array.length / 2];
    }
  }
}
