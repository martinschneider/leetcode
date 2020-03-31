package io.github.martinschneider.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/tweet-counts-per-frequency/
public class LC1348_TweetCountsPerFrequency {

  private Map<String, List<Integer>> tweets = new HashMap<>();

  public void recordTweet(String tweetName, int time) {
    List<Integer> times = tweets.containsKey(tweetName) ? tweets.get(tweetName) : new ArrayList<>();
    times.add(time);
    tweets.put(tweetName, times);
  }

  public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime,
      int endTime) {
    int delta = 0;
    switch (freq) {
      case "minute":
        delta = 60;
        break;
      case "hour":
        delta = 60 * 60;
        break;
      case "day":
        delta = 60 * 60 * 24;
        break;
      default:
        return null;
    }
    List<Integer> countsPerInterval = new ArrayList<>();
    while (startTime <= endTime) {
      int count = 0;
      for (Integer time : tweets.get(tweetName)) {
        if (time >= startTime && time < startTime + delta && time <= endTime) {
          count++;
        }
      }
      countsPerInterval.add(count);
      startTime += delta;
    }
    return countsPerInterval;
  }
}
