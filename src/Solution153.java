/*
153.寻找旋转排序数组中的最小值
 */
public class Solution153 {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right] && mid - 1 >= left && nums[mid - 1] < nums[mid]) {
                right = mid - 1;
            } else {
                return nums[mid];
            }
        }
        return -1;
    }
}
