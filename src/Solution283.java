public class Solution283 {
    public void moveZeroes(int[] nums) {
        int rk = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, ++rk, i);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
