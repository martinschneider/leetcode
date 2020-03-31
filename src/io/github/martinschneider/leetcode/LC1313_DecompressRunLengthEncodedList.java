package io.github.martinschneider.leetcode;

// https://leetcode.com/problems/decompress-run-length-encoded-list/
public class LC1313_DecompressRunLengthEncodedList {
  public int[] decompressRLElist(int[] nums) {
    int length = 0;
    for (int i = 0; i < nums.length; i += 2) {
      length += nums[i];
    }
    int[] result = new int[length];
    int idx = 0;
    for (int i = 0; i < nums.length; i += 2) {
      for (int j = 0; j < nums[i]; j++) {
        result[idx] = nums[i + 1];
        idx++;
      }
    }
    return result;
  }
}
