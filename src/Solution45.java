/*
45.跳跃游戏Ⅱ
 */
public class Solution45 {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] >= n - 1 - i) {
                dp[i] = 1;
            } else if (nums[i] == 0) {
                dp[i] = Integer.MAX_VALUE;
            } else {
                int min = Integer.MAX_VALUE;
                for (int j = i + 1; j <= i + nums[i]; j++) {
                    min = Math.min(min, dp[j]);
                }
                dp[i] = min == Integer.MAX_VALUE ? min : min + 1;
            }
        }
        return dp[0];
    }
}
