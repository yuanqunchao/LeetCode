import java.util.Random;

/*
215.数组中的第K个最大元素
 */
public class Solution215 {
    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums, 0, nums.length - 1, nums.length - k);
    }

    public int quickSort(int[] nums, int left, int right, int index) {
        int pos = randomPartition(nums, left, right);
        if (pos == index) {
            return nums[pos];
        } else {
            return pos < index ? quickSort(nums, pos + 1, right, index) : quickSort(nums, left, pos - 1, index);
        }
    }

    public int randomPartition(int[] nums, int left, int right) {
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
        return rk + 1;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
