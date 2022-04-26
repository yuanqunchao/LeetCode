/*
121.买卖股票的最佳时机
 */
public class Solution121 {
    public int maxProfit(int[] prices) {
        // 从后往前看，dp[i]表示第i天买股票能获得的最大利润
        int[] dp = new int[prices.length];
        int maxProfit = 0;
        for (int i = prices.length - 2; i >= 0; i--) {
            dp[i] = prices[i] < (prices[i + 1] + dp[i + 1]) ? prices[i + 1] + dp[i + 1] - prices[i] : 0;
            maxProfit = Math.max(maxProfit, dp[i]);
        }
        return maxProfit;
    }
}
