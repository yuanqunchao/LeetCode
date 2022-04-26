import java.util.*;

/*
912.排序数组——快速排序
 */
public class Solution912_1 {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int random = new Random().nextInt(right - left + 1) + left;
            swap(nums, random, right);
            int pivot = nums[right];
            int rk = left - 1;
            for (int i = left; i < right; i++) {
                if (nums[i] < pivot) {
                    swap(nums, ++rk, i);
                }
            }
            swap(nums, rk + 1, right);
            quickSort(nums, left, rk);
            quickSort(nums, rk + 2, right);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
