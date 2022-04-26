/*
912.排序数组——堆排序
 */
public class Solution912_2 {
    public int[] sortArray(int[] nums) {
        heapSort(nums);
        return nums;
    }

    public void heapSort(int[] nums) {
        int len = nums.length;
        // 1、调整堆
        for (int i = len / 2 - 1; i >= 0; i--) {
            adjustHeap(nums, i, len);
        }
        // 2、排序
        for (int i = len - 1; i >= 1; i--) {
            swap(nums, 0, i);
            adjustHeap(nums, 0, i);
        }
    }

    public void adjustHeap(int[] nums, int i, int len) {
        for (int k = 2 * i + 1; k < len; k = 2 * i + 1) {
            if (k + 1 < len && nums[k + 1] > nums[k]) {
                k += 1;
            }
            if (nums[i] < nums[k]) {
                swap(nums, i, k);
                i = k;
            } else {
                break;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
