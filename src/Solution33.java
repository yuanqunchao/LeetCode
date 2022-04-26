/*
33.搜索旋转排序数组
 */
public class Solution33 {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (target == nums[mid]) {  // 如果找到了，返回mid
                return mid;
            }
            if (nums[mid] >= nums[0]) {  // 说明在左边大的部分
                if (target > nums[mid] || target < nums[0]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (target < nums[mid] || target > nums[nums.length - 1]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}
