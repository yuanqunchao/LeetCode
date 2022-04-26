/*
162.寻找峰值
 */
public class Solution162 {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (mid - 1 >= left && nums[mid - 1] > nums[mid]) {
                right = mid - 1;
            } else if (mid + 1 <= right && nums[mid + 1] > nums[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
