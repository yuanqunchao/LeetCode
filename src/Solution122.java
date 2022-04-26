/*
122.买卖股票的最佳时机Ⅱ
 */
public class Solution122 {
    public int maxProfit(int[] prices) {
        int[] profit = new int[prices.length];
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i]) {
                profit[i] = prices[i + 1] - prices[i];
            }
        }
        int sum = 0;
        for (int i : profit) {
            sum += i;
        }
        return sum;
    }
}
