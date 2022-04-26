import java.util.Collections;

/*
1004.最大连续1的个数Ⅲ
 */
public class Solution1004 {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int left = 0;  // 窗口左边界
        int sum = 0;  // 窗口内0的个数
        int ans = 0;  // 最长窗口
        for (int right = 0; right < n; right++) {
            sum += 1 - nums[right];
            while (sum > k) {
                sum -= 1 - nums[left];
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
