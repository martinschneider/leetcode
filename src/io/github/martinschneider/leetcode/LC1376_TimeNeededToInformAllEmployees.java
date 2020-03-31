package io.github.martinschneider.leetcode;

// https://leetcode.com/problems/time-needed-to-inform-all-employees/
public class LC1376_TimeNeededToInformAllEmployees {
  public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
    int[] waitTimes = new int[manager.length];
    for (int i = 0; i < waitTimes.length; i++)
      waitTimes[i] = -1;
    for (int i = 0; i < manager.length; i++) {
      waitTimes[i] =
          getEmployeeInformTime(manager[i], manager, informTime, waitTimes) + informTime[i];
    }
    return findMax(waitTimes);
  }

  private int getEmployeeInformTime(int i, int[] manager, int[] informTime, int[] waitTimes) {
    if (i == -1)
      return 0;
    if (waitTimes[i] == -1) {
      waitTimes[i] =
          getEmployeeInformTime(manager[i], manager, informTime, waitTimes) + informTime[i];
    }
    return waitTimes[i];
  }

  private int findMax(int[] array) {
    int max = -1;
    for (int i = 0; i < array.length; i++) {
      max = Math.max(max, array[i]);
    }
    return max;
  }
}
