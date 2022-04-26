/*
912.排序数组——归并排序
 */
public class Solution912_3 {
    int[] tmp;

    public int[] sortArray(int[] nums) {
        tmp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void mergeSort(int[] nums, int left, int right) {
        if (left < right) {
            int mid = left + ((right - left) >> 1);
            // 对左右两部分分别调用归并排序
            mergeSort(nums, left, mid);
            mergeSort(nums, mid + 1, right);
            int i = left, j = mid + 1;  // i指向左半部分，j指向右半部分
            int cnt = 0;
            while (i <= mid && j <= right) {
                if (nums[i] <= nums[j]) {
                    tmp[cnt++] = nums[i++];
                } else {
                    tmp[cnt++] = nums[j++];
                }
            }
            while (i <= mid) {
                tmp[cnt++] = nums[i++];
            }
            while (j <= right) {
                tmp[cnt++] = nums[j++];
            }
            // 复制到原数组中
            for (int k = 0; k < right - left + 1; k++) {
                nums[k + left] = tmp[k];
            }
        }
    }
}
