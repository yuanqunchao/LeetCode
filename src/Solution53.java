/*
53.最大子数组和
 */
public class Solution53 {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        // 先初始化最小的子数组和为第一个元素，不能初始化为Integer的最小值，因为数组可能只有一个元素
        int maxSum = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i - 1] > 0 ? nums[i] + dp[i - 1] : nums[i];
            maxSum = Math.max(maxSum, dp[i]);
        }
        return maxSum;
    }
}
