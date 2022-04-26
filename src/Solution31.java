import java.util.Arrays;

/*
31.下一个排列
 */
public class Solution31 {
    public void nextPermutation(int[] nums) {
        int i = 0;  // 从后向前寻找第一个比前面的数大的数的下标
        for (int j = nums.length - 1; j > 0; j--) {
            if (nums[j] > nums[j - 1]) {
                i = j;
                break;
            }
        }
        if (i == 0) {  // 说明第一个数最大
            Arrays.sort(nums);
        } else {  // 位置i的数比它前面的数大，但是i后面的数可能也有比i前面的数大的数，而且这个数比位置i的数小
            int j = i - 1;
            for (int k = nums.length - 1; k > j; k--) {
                if (nums[k] > nums[j]) {
                    i = k;
                    break;
                }
            }
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
            // 第一个下标为开始下标，第二个下标为最后一个下标+1
            Arrays.sort(nums, j + 1, nums.length);
        }
    }
}
