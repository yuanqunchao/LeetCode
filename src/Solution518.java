import java.util.Arrays;

/*
518.零钱兑换Ⅱ
 */
public class Solution518 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;  // 0有1种组合方式，即不拿任何硬币
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }

}
