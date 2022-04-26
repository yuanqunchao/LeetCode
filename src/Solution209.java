/*
209.长度最小的子数组
 */
public class Solution209 {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int len = Integer.MAX_VALUE;
        int left = 0, right = 0;
        int n = nums.length;
        while (right < n) {
            sum += nums[right];
            while (sum >= target) {  // 说明找到子数组
                len = Math.min(len, right - left + 1);
                sum -= nums[left++];
            }
            right++;
        }
        return len == Integer.MAX_VALUE ? 0 : len;
    }
}
