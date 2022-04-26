/*
剑指Offer10-Ⅰ.斐波那契数列
 */
public class Solution10 {
    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        final int MOD = 1000000007;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            dp[i] = dp[i] % MOD;
        }
        return dp[n];
    }
}
