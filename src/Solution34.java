/*
34.在排序数组中查找元素的第一个和最后一个位置
 */
public class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return new int[]{-1, -1};
        }
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                int begin = mid, end = mid;
                while (begin - 1 >= 0 && nums[begin - 1] == target) {
                    begin--;
                }
                while (end + 1 < n && nums[end + 1] == target) {
                    end++;
                }
                return new int[]{begin, end};
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return new int[]{-1, -1};
    }
}
