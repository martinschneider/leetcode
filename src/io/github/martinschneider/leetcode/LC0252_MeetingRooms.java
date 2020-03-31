package io.github.martinschneider.leetcode;

import java.util.Arrays;

// https://leetcode.com/problems/meeting-rooms/
public class LC0252_MeetingRooms {
  public boolean canAttendMeetings(int[][] intervals) {
    Arrays.sort(intervals, (int[] o1, int[] o2) -> o1[0] - o2[0]);
    int right = Integer.MIN_VALUE;
    for (int[] interval : intervals) {
      if (interval[0] < right)
        return false;
      right = interval[1];
    }
    return true;
  }
}
