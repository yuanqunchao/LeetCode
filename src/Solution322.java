/*
322.零钱兑换
 */
public class Solution322 {
    public int coinChange(int[] coins, int amount) {
        // 每一个总金额所需要的最少的硬币数，总金额为0的话硬币数为0，遍历从1开始
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            boolean find = false;
            int num = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j] && dp[i - coins[j]] >= 0) {
                    find = true;
                    num = Math.min(num, dp[i - coins[j]] + 1);
                }
            }
            dp[i] = find ? num : -1;
        }
        return dp[amount];
    }
}
