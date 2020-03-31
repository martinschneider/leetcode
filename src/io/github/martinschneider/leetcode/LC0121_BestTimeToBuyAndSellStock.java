package io.github.martinschneider.leetcode;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class LC0121_BestTimeToBuyAndSellStock {
  public int maxProfit(int[] prices) {
    if (prices.length == 0) {
      return 0;
    }
    int maxProfit = 0;
    for (int i = 1; i < prices.length; i++) {
      maxProfit = Math.max(prices[i] - prices[i - 1], maxProfit);
      if (prices[i] > prices[i - 1]) {
        prices[i] = prices[i - 1];
      }
    }
    return maxProfit;
  }
}
